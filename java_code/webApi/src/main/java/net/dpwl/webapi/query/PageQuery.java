package net.dpwl.webapi.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.dpwl.webapi.entity.User;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/6 16:24
 */
@Data
@Schema(description = "分页查询参数实体")
public class PageQuery {
    @Schema(description = "当前页码")
    private Integer pageNum = 1;

    @Schema(description = "每页数量")
    private Integer pageSize = 10;

    @Schema(description = "排序字段")
    private String sortField = "id"; // 默认按id排序

    @Schema(description = "是否升序排序")
    private Boolean isAsc = true;

    public <T> Page<T> toMpPage() {
        Page<T> page = Page.of(pageNum, pageSize);
        // 1.2 排序条件（使用静态工厂方法替代直接new）
        if (isAsc) {
            page.addOrder(OrderItem.asc(sortField));
        } else {
            page.addOrder(OrderItem.desc(sortField));
        }
        return page;
    }
}
