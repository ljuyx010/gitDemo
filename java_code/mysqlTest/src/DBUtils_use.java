import JDBCUtils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/8 11:40
 */
public class DBUtils_use {
    public static void main(String[] args) throws SQLException {
        new DBUtils_use().testQueryMany();
    }
    // 使用apache-DBUtils工具类+Druid完成对表的crud操作
    public void testQueryMany() throws SQLException {
        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2.使用DBUtils类和接口，先引入DBUtils相关的jar包
        // 3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //String sql = "select * from common where title like ?";
        String sql = "select lid,title from common where title like ?";
        // sql语句也可以查询部分列
        // 4.使用queryRunner就可以执行相关的方法，返回ArrayList结果集
        // （1）query方法，执行sql语句，得到resultSet封装到ArrayList集合中返回
        //  (2)返回集合
        //  (3)connection:连接
        //  (4)sql:sql语句
        //  (5)BeanListHandler<>(Common.class)在将resultSet--反射-->Common对象-->封装到ArrayList集合中返回
        //   底层会使用反射机制去获取Common的属性，然后通过set方法，将resultSet中的值，封装到Common对象中
        //  (6)1:占位符参数  就是给sql语句中的?赋值
        //  (7)结果集在DButils中已经关闭了，不需要再关闭
        List<Common> list = queryRunner.query(connection, sql, new BeanListHandler<>(Common.class),"孝感%");
        //Common common = queryRunner.query(connection, sql, new BeanHandler<>(Common.class),"孝感%"); 获取单行数据
        //Object obj = queryRunner.query(connection, sql, new ScalarHandler(),"孝感%"); 获取单行数据的某个字段值

        for (Common common : list) {
            System.out.println(common);
        }
        // 5.关闭连接
        JDBCUtilsByDruid.close(null,null,connection);
    }

    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update common set uid = ? where lid = ?";
        int row = queryRunner.update(connection, sql, 1, 1); // 返回影响的行数
        System.out.println(row);
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
