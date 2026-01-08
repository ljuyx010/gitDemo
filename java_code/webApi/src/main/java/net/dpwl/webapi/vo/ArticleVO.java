package net.dpwl.webapi.vo;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/8 11:08
 */
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/8 11:08
 */
@Data
@Schema(description = "文章返回实体表")
public class ArticleVO {
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "用户id")
    private Integer uid;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
