
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/4 14:05
 */
public class Myjdbc {
    public static void main(String[] args)  {
        // 前置工作：在项目下创建一个文件夹比如libs，将mysql.jar拷贝
        //到该目录下，点击Add as Library(加入到库)..加入到项目中
        // 1. 加载驱动
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            DriverManager.registerDriver(driver); // 注册驱动
            //2. 得到连接
            String url = "jdbc:mysql://localhost:3306/xgzhongyuan";
            // jdbc:mysql://是固定的协议通过jdbc方式连接mysql，
            // localhost是数据库的主机地址还可以是ip，3306是数据库的端口号，
            // xgzhongyuan是数据库的名称
            // mysql的连接本质就是前面学过的socket连接
            Properties properties = new Properties();
            // 将用户名和密码放入properties对象中
            properties.setProperty("user","root"); // 用户
            properties.setProperty("password","H3u94c94kod0UjGuNmkfmqw0JMJRMF");// 密码
            Connection connect = DriverManager.getConnection(url,properties); // 连接数据库
            //3. 执行sql
            String sql = "insert into article (lid,cid,title,author,content) values (1,1,'测试文章','混江龙','这是一个测试文章')";
            //创建一个statement对象,用于执行sql语句并获取返回结果
            Statement statement = connect.createStatement();
            //执行sql
            int i = statement.executeUpdate(sql); // 执行sql语句,返回受影响的行数
            System.out.println(i);
            //4. 关闭连接
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void connect() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password); // 注册驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
