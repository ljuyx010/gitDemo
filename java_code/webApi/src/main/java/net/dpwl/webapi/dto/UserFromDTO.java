package net.dpwl.webapi.dto;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/5 14:01
 */

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/5 14:01
 */
@Data
@Schema(description = "用户注册实体表")
public class UserFromDTO {
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "openid")
    private String openid;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "头像")
    private String headimg;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "手机号")
    private String tel;

    @Schema(description = "地址")
    private String adr;
}
