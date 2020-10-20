package org.shardingsephere.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author cartoon
 * @description
 * @date 2019/12/23 2:07 PM
 */
@Configuration
@MapperScan(basePackages = "org.shardingsephere.demo.dao", sqlSessionTemplateRef = "testSqlSessionTemplate")
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean(name = "shardingDataSource")
    public DataSource getShardingDataSource() throws SQLException{
        ShardingRuleConfiguration configuration = new ShardingRuleConfiguration();
        configuration.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        configuration.getBindingTableGroups().add("user_info");
        PreciseShardingAlgorithm<Long> algorithm = new TableShardingAlgorithm();
        configuration.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", algorithm));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), configuration, new Properties());
    }

    @Bean
    public TableRuleConfiguration getUserTableRuleConfiguration(){
        TableRuleConfiguration configuration = new TableRuleConfiguration("user_info", "text.user_info_${0..1}");
        configuration.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return configuration;
    }

    public KeyGeneratorConfiguration getKeyGeneratorConfiguration(){
        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE","user_id");
        return result;

    }

    @Bean
    public DataSourceTransactionManager transactitonManager(DataSource shardingDataSource) {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource shardingDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(shardingDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("text", createDataSource());
        return result;
    }


    private DataSource createDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

}
