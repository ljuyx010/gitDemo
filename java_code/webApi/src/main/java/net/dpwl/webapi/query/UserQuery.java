package net.dpwl.webapi.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/5 15:26
 */
@Data
@Schema(description = "用户查询参数实体")
public class UserQuery extends PageQuery{

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "是否认证")
    private Integer yz;

    @Schema(description="手机号")
    private String tel;
}
