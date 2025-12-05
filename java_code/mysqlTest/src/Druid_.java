import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/5 16:23
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        // 1.导入druid的jar包
        // 2.加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        // 3.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 4.获取连接
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            //System.out.println("连接成功！");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("5000次连接耗时：" + (end - start) + "ms");
    }
}
