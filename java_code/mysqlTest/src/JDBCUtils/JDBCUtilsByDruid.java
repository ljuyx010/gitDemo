package JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/8 10:05
 * @description: 数据库连接池工具类，使用Druid连接池
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 获取连接池对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 关闭连接池,在数据库连接池技术中，关闭连接并不是真正的断开了数据库的连接，
    // 而是将连接对象回收至连接池，等待下一次使用。
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if(rs != null){
               rs.close();
            }
            if(st != null){
                st.close();
            }
            if (conn != null) {
               conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
