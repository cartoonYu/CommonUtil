package org.canal.demo;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author cartoon
 * @date 2020/12/27
 */
@Component
public class CanalClient implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(CanalClient.class);

    private final static int BATCH_SIZE = 1000;

    private String canalHost;

    private Integer canalPort;

    private String canalDestination;

    private String canalUserName;

    private String canalPassword;

    @Override
    public void afterPropertiesSet(){
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(canalHost, canalPort), canalDestination, canalUserName,  canalPassword);
        try {
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            while (true) {
                Message message = connector.getWithoutAck(BATCH_SIZE);
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    printEntry(message.getEntries());
                }
                connector.ack(batchId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.disconnect();
        }
    }

    private static void printEntry(List<CanalEntry.Entry> entries) {
        for (CanalEntry.Entry entry : entries) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            CanalEntry.RowChange rowChange;
            try {
                rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("parse row change error: " + entry.toString(), e);
            }
            CanalEntry.EventType eventType = rowChange.getEventType();
            log.info("database: {}, table: {}, eventType : {}", entry.getHeader().getSchemaName(), entry.getHeader().getTableName(), eventType);
            if (rowChange.getIsDdl()) {
                log.info("current sql is ddl sql, sql: {}", rowChange.getSql());
            }
            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    printColumn(rowData.getBeforeColumnsList());
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            log.info("{}: {}, update: {}", column.getName(), column.getValue(), column.getUpdated());
        }
    }

    @PostConstruct
    public void init(){
        canalHost = "cartoon-ali.com";
        canalPort = 11111;
        canalDestination = "example";
        canalUserName = "";
        canalPassword = "";
    }
}
