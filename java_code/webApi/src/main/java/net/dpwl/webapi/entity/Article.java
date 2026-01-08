package net.dpwl.webapi.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 混江龙
 * @since 2026-01-05
 */
@Data
@TableName("dp_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "栏目id")
    @TableField("cid")
    private Integer cid;

    @Schema(description = "标题")
    @TableField("title")
    private String title;

    @Schema(description = "关键字")
    @TableField("keyword")
    private String keyword;

    @Schema(description = "描述")
    @TableField("description")
    private String description;

    @Schema(description = "封面图")
    @TableField("pic")
    private String pic;

    @Schema(description = "图集")
    @TableField("pics")
    private String pics;

    @Schema(description = "推荐")
    @TableField("tj")
    private Integer tj;

    @Schema(description = "专题")
    @TableField("sid")
    private Integer sid;

    @Schema(description = "作者")
    @TableField("author")
    private String author;

    @Schema(description = "来源")
    @TableField("from")
    private String from;

    @Schema(description = "发布日期")
    @TableField("time")
    private Integer time;

    @Schema(description = "发文人id")
    @TableField("uid")
    private Integer uid;

    @Schema(description = "外链")
    @TableField("url")
    private String url;

    @Schema(description = "正文")
    @TableField("content")
    private String content;

    @Schema(description = "是否删除")
    @TableField("del")
    private Integer del;

    @Schema(description = "浏览量")
    @TableField("click")
    private Integer click;


}
