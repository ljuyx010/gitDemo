import com.mchange.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/5 14:49
 */
public class C3p0_ {
    public static void main(String[] args) {
        new C3p0_().testC3p0();
        //new C3p0().testC3p0_2();
    }

    // 方式1.相关参数，在程序中指定user，url，password，driverClass
    @Test
    public void testC3p0(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            // 获取配置文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("username");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            // 给数据源设置参数
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setJdbcUrl(url);
            dataSource.setDriverClass(driver);
            // 设置初始化连接数
            dataSource.setInitialPoolSize(10);
            // 设置最大连接数
            dataSource.setMaxPoolSize(50);
            // 获取连接
            Connection connection = dataSource.getConnection();
            System.out.println("连接成功ok");
            // 关闭连接
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 第二种方式：使用配置文件模板来完成
    // 1.将c3p0 提供的c3p0.xml拷贝到src目录下
    // 2.修改c3p0.xml 中的相关参数
    // 3.在程序中使用ComboPooledDataSource() 来获取连接池对象
    @Test
    public void testC3p0_2(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource("test");
        try {
            // 获取连接
            Connection connection = dataSource.getConnection();
            System.out.println("连接成功ok");
            // 关闭连接
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
