package net.dpwl.webapi.entity;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 12:03
 */
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("dp_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String openid;

    private String nickname;

    private Integer sex;

    private String headimg;

    private String name;

    private String tel;

    private String adr;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime logintime; //日期时间不能为0，否则会报错

    //@TableLogic
    private Integer yz;

}
