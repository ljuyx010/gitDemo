package net.dpwl.webapi.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.dpwl.webapi.vo.UserVO;

import java.util.List;
import java.util.function.Function;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/6 16:30
 */
@Data
@Schema(description = "分页查询结果实体")
public class PageDTO<T> {
    @Schema(description = "总页码")
    private Long pages;

    @Schema(description = "总记录数")
    private Long total;

    @Schema(description = "分页数据")
    private List<T> list;

    public static <PO,VO> PageDTO<VO> of(Page<PO> p, Class<VO> clazz){
        PageDTO<VO> pageDTO = new PageDTO<>();
        pageDTO.setPages(p.getPages());
        pageDTO.setTotal(p.getTotal());
        List<PO> records = p.getRecords();
        if(CollUtil.isEmpty(records)){
            // 判断分页时间是否为空
            pageDTO.setList(List.of());
            return pageDTO;
        }
        pageDTO.setList(BeanUtil.copyToList(records, clazz));
        return pageDTO;
    }
    // 使用函数式接口转换分页数据
    public static <PO,VO> PageDTO<VO> of(Page<PO> p, Function<PO,VO> convertor){
        PageDTO<VO> pageDTO = new PageDTO<>();
        pageDTO.setPages(p.getPages());
        pageDTO.setTotal(p.getTotal());
        List<PO> records = p.getRecords();
        if(CollUtil.isEmpty(records)){
            // 判断分页时间是否为空
            pageDTO.setList(List.of());
            return pageDTO;
        }
        pageDTO.setList(records.stream().map(convertor).toList());
        return pageDTO;
    }
}
