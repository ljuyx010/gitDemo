import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/4 15:46
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("mysqlTest\\src\\mysql.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password); // 注册驱动
            Statement statement = connection.createStatement();
            String sql = "select * from common";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
            resultSet.close(); // 关闭结果集
            statement.close(); // 关闭语句
            connection.close(); // 关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
