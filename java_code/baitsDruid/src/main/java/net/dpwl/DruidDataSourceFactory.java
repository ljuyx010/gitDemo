package net.dpwl;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/24 10:18
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Druid数据源工厂类，用于MyBatis集成Druid连接池
 */
public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties properties;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }
}