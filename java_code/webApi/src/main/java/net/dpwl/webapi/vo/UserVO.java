package net.dpwl.webapi.vo;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/5 14:15
 */
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/5 14:15
 */
@Data
@Schema(description = "用户返回实体表")
public class UserVO {
    @Schema(description = "id")
    private Integer id;

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

     @Schema(description = "文章列表")
    private List<ArticleVO> article;
}
