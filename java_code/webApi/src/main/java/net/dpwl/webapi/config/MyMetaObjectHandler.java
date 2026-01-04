package net.dpwl.webapi.config;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 14:02
 */
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 14:02
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
//        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("logintime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("logintime", LocalDateTime.now(), metaObject);
    }
}
