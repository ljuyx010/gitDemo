import org.junit.*;

import java.util.List;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/8 15:45
 */
public class TestDao {
    // 测试CommonDao类对common表的crud操作
    @Test
    public void testCommonDao() {
        CommonDao commonDao = new CommonDao();
        // 测试新增
        commonDao.update("insert into common(lid,uid,title) values(?,?,?)","1", "31","测试新增");
        // 测试查询
        List<Common> commons = commonDao.queryMulti("select * from common where title like ?", Common.class, "孝感%");
        System.out.println(commons);
    }
}
