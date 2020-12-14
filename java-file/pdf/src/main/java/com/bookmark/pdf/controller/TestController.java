package com.bookmark.pdf.controller;

import com.bookmark.pdf.exceltopdf.util.ExcelConvertPDF;
import com.bookmark.pdf.exceltopdf.util.vo.GoldInStoreExcel;
import com.itextpdf.text.RectangleReadOnly;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hj
 * @DateTime: 2020/12/12 16:29
 * @Description:
 */
@RestController
@RequestMapping("/data")
public class TestController {
    static String resourcesDir = "D:\\projects\\myprojects\\bookmark\\java-file\\pdf\\src\\main\\resources\\入库.xls";
    static String outputDir = "target/output";
    @RequestMapping("/download")
    @ApiOperation("导出pdf测试")
    public void download(HttpServletResponse response) throws Exception {
        GoldInStoreExcel goldInStoreExcel = new GoldInStoreExcel();
        goldInStoreExcel.setCustomerName("这个客户名称test");
        Map<Object, String> voAndSheetName2 = new HashMap<>();
        voAndSheetName2.put(goldInStoreExcel, "Sheet1");
        Workbook workbook = ExcelConvertPDF.outPutWorkbookByModel(voAndSheetName2, resourcesDir);
        List<Workbook> workbooks = new ArrayList<Workbook>();
        workbooks.add(workbook);
        //设置导出的页面的大小
        RectangleReadOnly pageSize = new RectangleReadOnly(1000.0F, 850.0F);
        //定义输出流 也可以支持web的httpRespone
        String pathOfPdf ="D:\\projects\\myprojects\\bookmark\\java-file\\pdf\\src\\main\\resources" +"/"+ "test2.pdf";
        FileOutputStream fos = new FileOutputStream(pathOfPdf);
        ExcelConvertPDF.ExcelConvertPDF(workbooks, fos, pageSize);
    }
}
