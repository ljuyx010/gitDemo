package net.dpwl.hellospringboot.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Excel视图类 - 使用纯Apache POI实现（替代已弃用的AbstractXlsxView）
 * 
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/5 17:02
 */
@Component
public class ExcelView implements View {

    @Override
    public String getContentType() {
        // 返回Excel文件的MIME类型
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. 设置响应头信息
        response.setContentType(getContentType());
        response.setHeader("Content-Disposition", "attachment; filename=orders_export.xlsx");
        
        // 2. 从model中获取Orders数据列表
        List<net.dpwl.hellospringboot.entity.Orders> ordersList = (List<net.dpwl.hellospringboot.entity.Orders>) model.get("ordersList");
        
        // 3. 创建Excel工作簿（使用XSSFWorkbook生成.xlsx格式）
        try (Workbook workbook = new XSSFWorkbook();
             OutputStream outputStream = response.getOutputStream()) {
            
            // 4. 创建Excel工作表
            Sheet sheet = workbook.createSheet("订单数据");
            
            // 5. 设置列宽
            sheet.setColumnWidth(0, 20 * 256); // ID列
            sheet.setColumnWidth(1, 30 * 256); // 订单号列
            sheet.setColumnWidth(2, 30 * 256); // 客户名列
            sheet.setColumnWidth(3, 20 * 256); // 金额列
            sheet.setColumnWidth(4, 20 * 256); // 状态列
            sheet.setColumnWidth(5, 30 * 256); // 创建时间列
            
            // 6. 创建表头行
            Row headerRow = sheet.createRow(0);
            
            // 7. 创建单元格样式
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dataStyle = createDataStyle(workbook);
            
            // 8. 设置表头内容
            String[] headers = {"ID", "订单号", "客户名", "金额", "状态", "创建时间"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }
            
            // 9. 填充数据行
            int rowNum = 1;
            for (net.dpwl.hellospringboot.entity.Orders order : ordersList) {
                Row dataRow = sheet.createRow(rowNum++);
                
                // ID
                Cell idCell = dataRow.createCell(0);
                idCell.setCellValue(order.getId());
                idCell.setCellStyle(dataStyle);
                
                // 订单号
                Cell orderNumberCell = dataRow.createCell(1);
                orderNumberCell.setCellValue(order.getOrderNumber());
                orderNumberCell.setCellStyle(dataStyle);
                
                // 客户名
                Cell customerNameCell = dataRow.createCell(2);
                customerNameCell.setCellValue(order.getCustomerName());
                customerNameCell.setCellStyle(dataStyle);
                
                // 金额
                Cell amountCell = dataRow.createCell(3);
                amountCell.setCellValue(order.getAmount());
                amountCell.setCellStyle(dataStyle);
                
                // 状态
                Cell statusCell = dataRow.createCell(4);
                statusCell.setCellValue(order.getStatus());
                statusCell.setCellStyle(dataStyle);
                
                // 创建时间
                Cell createTimeCell = dataRow.createCell(5);
                createTimeCell.setCellValue(order.getCreateTime());
                createTimeCell.setCellStyle(dataStyle);
            }
            
            // 10. 将工作簿写入输出流
            workbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            // 处理异常
            throw new RuntimeException("Excel导出失败", e);
        }
    }
    
    /**
     * 创建表头样式
     */
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
    
    /**
     * 创建数据行样式
     */
    private CellStyle createDataStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        return style;
    }
}