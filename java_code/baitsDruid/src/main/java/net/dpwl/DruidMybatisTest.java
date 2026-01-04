package net.dpwl;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class DruidMybatisTest {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 1. 加载 MyBatis 配置文件
            System.out.println("正在加载MyBatis配置文件...");
            Reader reader = Resources.getResourceAsReader("mybatis-druid.xml");

            // 2. 读取数据库配置文件
            System.out.println("正在读取数据库配置文件...");
            Properties properties = Resources.getResourceAsProperties("db.properties");
            System.out.println("数据库配置：");
            System.out.println("  Driver: " + properties.getProperty("driver"));
            System.out.println("  URL: " + properties.getProperty("url"));
            System.out.println("  Username: " + properties.getProperty("username"));

            // 3. 使用XML配置构建SqlSessionFactory
            System.out.println("正在解析XML配置并构建SqlSessionFactory...");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(reader, properties);
            System.out.println("基于XML配置的SqlSessionFactory构建成功！");

            // 4. 从SqlSessionFactory获取Configuration对象
            Configuration configuration = sqlSessionFactory.getConfiguration();

            // 5. 手动构建Druid数据源并配置
            System.out.println("正在初始化Druid数据源...");
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(properties.getProperty("driver"));
            druidDataSource.setUrl(properties.getProperty("url"));
            druidDataSource.setUsername(properties.getProperty("username"));
            druidDataSource.setPassword(properties.getProperty("password"));

            // --- Druid 特有配置 (连接池优化) ---
            druidDataSource.setInitialSize(5);      // 初始连接数
            druidDataSource.setMinIdle(5);         // 最小空闲连接数
            druidDataSource.setMaxActive(20);      // 最大活跃连接数
            druidDataSource.setMaxWait(60000);     // 获取连接最大等待时间
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000); // 间隔多久进行一次检测
            druidDataSource.setMinEvictableIdleTimeMillis(300000);   // 一个连接最小空闲时间
            druidDataSource.setValidationQuery("SELECT 1");          // 检测连接是否有效的SQL
            druidDataSource.setTestWhileIdle(true);
            druidDataSource.setTestOnBorrow(false);
            druidDataSource.setTestOnReturn(false);

            // 测试数据源连接
            System.out.println("正在测试数据库连接...");
            druidDataSource.getConnection().close();
            System.out.println("数据库连接测试成功！");

            // 6. 创建新的Environment，替换数据源
            Environment environment = new Environment(
                    configuration.getEnvironment().getId(),
                    configuration.getEnvironment().getTransactionFactory(),
                    druidDataSource
            );

            // 7. 更新Configuration的Environment
            configuration.setEnvironment(environment);

            // 8. 创建新的SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            System.out.println("使用Druid数据源的SqlSessionFactory构建成功！");

            // 9. 使用MyBatis执行查询
            System.out.println("正在执行数据库查询...");
            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user = mapper.selectUser(1);
                System.out.println("查询结果：" + user);
            }

        } catch (IOException e) {
            System.err.println("配置文件加载错误：");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("数据库操作错误：");
            e.printStackTrace();
        }
    }

    public static void oldmain(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 1. 加载 MyBatis 配置文件
            System.out.println("正在加载MyBatis配置文件...");
            Reader reader = Resources.getResourceAsReader("mybatis-druid.xml");

            // 2. 读取数据库配置文件
            System.out.println("正在读取数据库配置文件...");
            Properties properties = Resources.getResourceAsProperties("db.properties");
            System.out.println("数据库配置：");
            System.out.println("  Driver: " + properties.getProperty("driver"));
            System.out.println("  URL: " + properties.getProperty("url"));
            System.out.println("  Username: " + properties.getProperty("username"));

            // 3. 手动构建 Druid 数据源
            System.out.println("正在初始化Druid数据源...");
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(properties.getProperty("driver"));
            druidDataSource.setUrl(properties.getProperty("url"));
            druidDataSource.setUsername(properties.getProperty("username"));
            druidDataSource.setPassword(properties.getProperty("password"));

            // --- Druid 特有配置 (连接池优化) ---
            druidDataSource.setInitialSize(5);      // 初始连接数
            druidDataSource.setMinIdle(5);         // 最小空闲连接数
            druidDataSource.setMaxActive(20);      // 最大活跃连接数
            druidDataSource.setMaxWait(60000);     // 获取连接最大等待时间
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000); // 间隔多久进行一次检测
            druidDataSource.setMinEvictableIdleTimeMillis(300000);   // 一个连接最小空闲时间
            druidDataSource.setValidationQuery("SELECT 1");          // 检测连接是否有效的SQL
            druidDataSource.setTestWhileIdle(true);
            druidDataSource.setTestOnBorrow(false);
            druidDataSource.setTestOnReturn(false);

            // 测试数据源连接
            System.out.println("正在测试数据库连接...");
            druidDataSource.getConnection().close();
            System.out.println("数据库连接测试成功！");

            // 4. 手动构建 SqlSessionFactory
            System.out.println("正在构建SqlSessionFactory...");
            // 使用 Configuration 对象来设置数据源，而不是依赖 XML 解析
            Environment environment = new Environment("development",
                    new org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory(),
                    druidDataSource);
            Configuration configuration = new Configuration(environment);
            configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰映射

            // 注册 Mapper 接口
            configuration.addMapper(UserMapper.class);

            // 5. 构建工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            System.out.println("SqlSessionFactory构建成功！");

            // 6. 使用 MyBatis 执行查询
            System.out.println("正在执行数据库查询...");
            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user = mapper.selectUser(1);
                System.out.println("查询结果：" + user);
            }

        } catch (IOException e) {
            System.err.println("配置文件加载错误：");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("数据库操作错误：");
            e.printStackTrace();
        }
    }


}