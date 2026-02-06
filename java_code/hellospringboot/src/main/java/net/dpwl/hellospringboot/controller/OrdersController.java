package net.dpwl.hellospringboot.controller;

import net.dpwl.hellospringboot.entity.Result;
import net.dpwl.hellospringboot.view.ExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import net.dpwl.hellospringboot.entity.Orders;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/4 16:24
 */

@RestController
@RequestMapping("/orders")
public class OrdersController {
    //声明RestTemplate
    private final RestTemplate restTemplate;

    // 当bean没有无参构造函数的时候，spring将自动拿到有参构造函数，将其参数自动注入
    @Autowired
    public OrdersController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 测试方法
    @RequestMapping("/test")
    public String test() {
        // 需要远程调用orders服务的/test接口
        Result result = restTemplate.getForObject("http://localhost:8080/hello/world", Result.class);
        System.out.println(result);
        return "hello orders";
    }

    /**
     * 导出订单数据到Excel
     * @return ModelAndView包含Excel视图和订单数据
     */
    @RequestMapping("/exportExcel")
    public ModelAndView exportExcel() {
        // 1. 创建测试数据
        List<Orders> ordersList = generateTestData();

        // 2. 创建ModelAndView，指定使用ExcelView
        ModelAndView mav = new ModelAndView(new ExcelView());

        // 3. 将数据添加到模型中
        mav.addObject("ordersList", ordersList);

        return mav;
    }

    /**
     * 生成测试数据
     * @return 订单数据列表
     */
    private List<Orders> generateTestData() {
        List<Orders> ordersList = new ArrayList<>();

        ordersList.add(new Orders(1, "ORD20260205001", "张三", 1234.56, "已支付", "2026-02-05 10:30:00"));
        ordersList.add(new Orders(2, "ORD20260205002", "李四", 7890.12, "待支付", "2026-02-05 11:45:00"));
        ordersList.add(new Orders(3, "ORD20260205003", "王五", 3456.78, "已发货", "2026-02-05 13:20:00"));
        ordersList.add(new Orders(4, "ORD20260205004", "赵六", 9012.34, "已完成", "2026-02-05 14:15:00"));
        ordersList.add(new Orders(5, "ORD20260205005", "钱七", 5678.90, "已取消", "2026-02-05 15:50:00"));

        return ordersList;
    }
}
