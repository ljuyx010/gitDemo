import JDBCUtils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/8 15:20
 */
public class BasicDao<T> {
    // <T> 表示泛型,可以代表任意类型
    private QueryRunner qr = new QueryRunner();

    // DML操作（增删改）
    public int update(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int row = qr.update(connection, sql, params);
            return row;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 返回多行结果集（查询）
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 返回单行结果集（查询）
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 返回单列结果集（查询）
    public Object queryScalar(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
