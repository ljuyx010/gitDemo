package JDBCUtils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/5 9:43
 */
public class JDBCUtils {
    // 数据库连接信息,因为只需要连接一次,所以设置为静态常量
    public static String url;
    public static String user ;
    public static String password ;
    public static String driver ;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("mysqlTest\\src\\mysql.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);

        } catch (Exception e) {
            // 在实际开发中，我们可以这样处理
            //1.将编译异常转成运行时异常
            //2.这时调用者，可以选择捕获异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            // 返回数据库连接对象
           return DriverManager.getConnection(url, user, password); // 注册驱动
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭数据库连接
    /**
     * 关闭数据库连接 需要关闭的对象可能有 1. ResultSet 2. PreparedStatement 或者 Statement 3. Connection
     * @param set 数据集对象,如果没有数据集对象或数据不需要关闭则传入null
     * @param connection 数据库连接对象
     * @param statement 数据库操作对象
     */
    public static void close(ResultSet set, Statement statement,Connection connection) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
