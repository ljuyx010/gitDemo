package net.dpwl.controller;

import net.dpwl.service.QuickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/23 11:56
 */
@Controller
public class QuickController {

    // 直接注入service进行使用
    @Autowired
    private QuickService quickService;

    @RequestMapping("/show")
    public String  show(){
        System.out.println("show runing..."+quickService);
        return "/index.jsp";
    }
}
