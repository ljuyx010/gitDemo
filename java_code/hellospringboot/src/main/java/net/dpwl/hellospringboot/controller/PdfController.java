package net.dpwl.hellospringboot.controller;

import net.dpwl.hellospringboot.view.PdfView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * PDF控制器
 * 处理PDF相关请求
 */
@Controller
@RequestMapping("/pdf")
public class PdfController {

    /**
     * 显示示例PDF文档
     * @return ModelAndView包含PdfView
     */
    @RequestMapping("/showSample")
    public ModelAndView showSamplePdf() {
        // 创建ModelAndView，指定使用PdfView
        ModelAndView mav = new ModelAndView(new PdfView());

        // 不传递任何PDF数据，将使用示例PDF
        return mav;
    }

    /**
     * 从文件路径显示PDF文档
     * @return ModelAndView包含PdfView和文件路径
     */
    @RequestMapping("/showFromFile")
    public ModelAndView showPdfFromFile() {
        // 创建ModelAndView，指定使用PdfView
        ModelAndView mav = new ModelAndView(new PdfView());

        // 设置PDF文件路径（这里需要确保文件存在）
        // 注意：实际使用时需要替换为真实的文件路径
        mav.addObject("pdfFilePath", "D:\\Download\\test.pdf");

        return mav;
    }

    /**
     * 从字节数组显示PDF文档
     * @return ModelAndView包含PdfView和PDF字节数组
     */
    @RequestMapping("/showFromText")
    public ModelAndView showPdfFromBytes() {
        // 创建ModelAndView，指定使用PdfView
        ModelAndView mav = new ModelAndView(new PdfView());
        mav.addObject("textContent", "确保系统中安装了相应的中文字体（Windows系统通常默认安装了黑体和宋体）");
        // 这里可以从数据库或其他来源获取PDF字节数组
        // 示例中不提供字节数组，将使用示例PDF

        return mav;
    }
}