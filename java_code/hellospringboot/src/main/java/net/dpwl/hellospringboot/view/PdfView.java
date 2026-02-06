package net.dpwl.hellospringboot.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * PDF视图类 - 使用Apache PDFBox 3.x实现PDF文档显示
 *
 * @author 混江龙
 * @version 2.0
 * @time 2026/2/6 10:51
 */
@Component("pdfView")
public class PdfView extends AbstractView {

    private String defaultFilename = "document.pdf";
    private boolean forceDownload = false;

    public PdfView() {
        // 设置默认的MIME类型为PDF
        setContentType("application/pdf");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 设置响应头信息
        response.setContentType(getContentType());

        // 从model中获取配置
        String filename = (String) model.getOrDefault("filename", defaultFilename);
        Boolean download = (Boolean) model.getOrDefault("forceDownload", forceDownload);

        String contentDisposition = Boolean.TRUE.equals(download) ? "attachment" : "inline";
        response.setHeader("Content-Disposition",
                String.format("%s; filename=\"%s\"", contentDisposition, filename));

        // 2. 从model中获取PDF数据或路径
        String pdfFilePath = (String) model.get("pdfFilePath");
        byte[] pdfBytes = (byte[]) model.get("pdfBytes");
        String textContent = (String) model.get("textContent");

        try (OutputStream outputStream = response.getOutputStream()) {

            if (pdfFilePath != null) {
                // 3.1 从文件路径读取PDF文档 - PDFBox 3.x方式
                try (PDDocument document = Loader.loadPDF(new File(pdfFilePath))) {
                    document.save(outputStream);
                }
            } else if (pdfBytes != null) {
                // 3.2 从字节数组生成PDF文档 - PDFBox 3.x方式
                try (PDDocument document = Loader.loadPDF(pdfBytes)) {
                    document.save(outputStream);
                }
            } else if (textContent != null) {
                // 3.3 从文本内容生成PDF
                try (PDDocument document = createPdfFromText(textContent, model)) {
                    document.save(outputStream);
                }
            } else {
                // 3.4 如果没有提供PDF数据，生成一个示例PDF文档
                try (PDDocument document = createSamplePdf()) {
                    document.save(outputStream);
                }
            }

            outputStream.flush();
        } catch (IOException e) {
            // 处理异常
            throw new RuntimeException("PDF文档显示失败", e);
        }
    }

    /**
     * 创建一个示例PDF文档（当没有提供PDF数据时使用）
     */
    private PDDocument createSamplePdf() throws IOException {
        PDDocument document = new PDDocument();

        // 创建一个页面
        PDPage page = new PDPage();
        document.addPage(page);
        // 加载支持中文的字体
        PDFont chineseFont = loadChineseFont(document);
        // 创建内容流
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // 设置字体和字号
            contentStream.setFont(chineseFont, 16);
            // 设置文本颜色
            contentStream.setNonStrokingColor(0, 0, 0);
            // 设置文本位置（x, y坐标）
            contentStream.newLineAtOffset(100, 700);
            // 添加文本内容（包含中文）
            contentStream.showText("Spring Boot PDF示例 - 支持中文");
            // 换行
            contentStream.newLineAtOffset(0, -30);
            contentStream.setFont(chineseFont, 12);
            contentStream.showText("这是一个使用Apache PDFBox 3.x生成的示例PDF文档，现在支持中文显示！");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("当前时间: " + new java.util.Date());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("中文测试：你好，世界！这是中文文本示例。");
            // 结束绘制文本
            contentStream.endText();
        }

        return document;
    }

    /**
     * 加载支持中文的字体
     */
    private PDFont loadChineseFont(PDDocument document) throws IOException {
        // 尝试加载Windows系统自带的中文字体
        String[] fontPaths = {
                "C:/Windows/Fonts/simhei.ttf", // 黑体
                "C:/Windows/Fonts/simsun.ttc", // 宋体（需要指定index 0）
                "/usr/share/fonts/truetype/wqy/wqy-microhei.ttc", // Linux系统下的文泉驿微米黑
                "/Library/Fonts/SimHei.ttf" // macOS系统下的黑体
        };

        for (String fontPath : fontPaths) {
            java.nio.file.Path path = java.nio.file.Paths.get(fontPath);
            if (java.nio.file.Files.exists(path)) {
                try {
                    if (fontPath.endsWith(".ttc")) {
                        // TTC字体文件（TrueType Collection）需要指定索引
                        return PDType0Font.load(document, new java.io.File(fontPath));
                    } else {
                        // TTF字体文件
                        return PDType0Font.load(document, new java.io.File(fontPath));
                    }
                } catch (IOException e) {
                    // 如果加载失败，尝试下一个字体路径
                    continue;
                }
            }
        }

        // 如果所有字体都加载失败，回退到默认字体
        System.err.println("无法加载中文字体，将使用默认字体");
        return new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    }

    /**
     * 从文本内容创建PDF
     */
    private PDDocument createPdfFromText(String textContent, Map<String, Object> model) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        // 加载支持中文的字体
        PDFont chineseFont = loadChineseFont(document);
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // 可配置的字体大小
            float fontSize = 16;
            float margin = 50;

            if (model.containsKey("fontSize")) {
                fontSize = ((Number) model.get("fontSize")).floatValue();
            }

            // 设置字体和字号
            contentStream.setFont(chineseFont, fontSize);
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, page.getMediaBox().getHeight() - margin);

            // 简单文本换行处理
            String[] lines = textContent.split("\n");
            float leading = fontSize * 1.5f;

            for (String line : lines) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -leading);
            }

            contentStream.endText();
        }

        return document;
    }

    // Setters for configuration
    public void setDefaultFilename(String defaultFilename) {
        this.defaultFilename = defaultFilename;
    }

    public void setForceDownload(boolean forceDownload) {
        this.forceDownload = forceDownload;
    }

}