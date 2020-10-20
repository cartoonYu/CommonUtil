package org.shardingsephere.demo.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import java.util.Collection;

/**
 * @author cartoon
 * @description
 * @date 2019/12/23 2:00 PM
 */
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for(String str : collection){
            if(str.endsWith(Long.parseLong(preciseShardingValue.getValue().toString()) % 2 + "")){
                return str;
            }
        }
        throw new IllegalArgumentException();
    }
}
