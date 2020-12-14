package com.bookmark.pdf.exceltopdf.util;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.CollectionUtils;

import com.bookmark.pdf.exceltopdf.util.annotation.CellVal;
import com.itextpdf.text.RectangleReadOnly;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.*;

/**
 * @ClassName ExcelConvertPDF
 * @Author laixiaoxing
 * @Date 2019/2/19 上午12:26
 * @Description excel转pdf工具类
 * @Version 1.0
 */
public class ExcelConvertPDF {

    /**
     * excel转为pdf并导出 http方法
     *目前不支持多sheet  如果有多个sheet建议分成多个xls文档，可以导出到一个pdf文件里面
     * @param
     * @param response
     * @throws IOException
     */
    public static void ExcelConvertPDF(List<Workbook> workbook, HttpServletResponse response, RectangleReadOnly pageSize) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        List<ExcelObject> objects = new ArrayList<>();
        for (Workbook wb : workbook) {
            objects.add(new ExcelObject(null, wb));
        }
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + "default" + ".pdf");
        Excel2Pdf pdf = new Excel2Pdf(objects, out,Boolean.FALSE,pageSize);
        pdf.convert();
    }


    /**
     * excel转为pdf并导出
     *目前不支持多sheet  如果有多个sheet建议分成多个xls文档，可以导出到一个pdf文件里面
     * @param
     * @param out
     * @throws IOException
     */
    public static void ExcelConvertPDF(List<Workbook> workbook, OutputStream out,RectangleReadOnly pageSize) throws Exception {
        List<ExcelObject> objects =new ArrayList<ExcelObject>();
        for (Workbook wb : workbook) {
            objects.add(new ExcelObject(null, wb));
        }
        Excel2Pdf pdf = new Excel2Pdf(objects, out,Boolean.FALSE,pageSize);
        pdf.convert();
    }

    /**
     * excel转pdf的中间方法
     *
     * @param voAndSheetName excel的vo和对应的sheetName
     * @param templateUrl    excel的模版url 该模版必须存储在template目录下且是xls形式
     * @return 返回填充好的Workbook 以备转为pdf用
     * @throws Exception
     */
    public static Workbook outPutWorkbookByModel(Map<Object, String> voAndSheetName, String templateUrl) throws Exception {
        FileInputStream fis = new FileInputStream(templateUrl);
        Workbook workbook = createWorkBook(fis, ExcelTypeEnum.XLS);
        setSheets(voAndSheetName, workbook);
        return workbook;

    }


    private static void setSheets(Map<Object, String> VOAndSheet, Workbook workbook) throws Exception {
        for (Map.Entry<Object, String> objectStringEntry : VOAndSheet.entrySet()) {
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(objectStringEntry.getValue());
            List<CellModel> cellModelEOS = getCellModel(objectStringEntry.getKey());
            for (CellModel cellModel : cellModelEOS) {
                Cell cell = sheet.getRow(cellModel.getRow() - 1).getCell(cellModel.getCol() - 1);
                setCell(cellModel, cell);
            }
        }
    }

    /**
     * 设置单元格的值
     *
     * @param cellModel
     * @param cell
     */
    private static void setCell(CellModel cellModel, Cell cell) {
        if (cellModel.getValue() instanceof String) {
            cell.setCellValue((String) cellModel.getValue());
        } else if (cellModel.getValue() instanceof Date) {
            cell.setCellValue(String.valueOf(cellModel.getValue()));
        } else if (cellModel.getValue() instanceof Double) {
            cell.setCellValue(String.valueOf(cellModel.getValue()));
        } else if (cellModel.getValue() instanceof Calendar) {
            cell.setCellValue(String.valueOf(cellModel.getValue()));
        } else if (cellModel.getValue() instanceof RichTextString) {
            cell.setCellValue(String.valueOf(cellModel.getValue()));
        } else if (cellModel.getValue() instanceof Boolean) {
            cell.setCellValue(String.valueOf(cellModel.getValue()));
        } else if (cellModel.getValue() instanceof BigDecimal) {
            cell.setCellValue(String.valueOf(((BigDecimal) cellModel.getValue()).doubleValue()));
        }
        //也可以自己定义自己想写入的类型
        //        } else {
        //            throw new InvalidParameterException("excel单元格数据类型错误！！");
        //        }
    }


    /**
     * 解析注解
     *
     * @param obj
     * @return
     */
    private static List<CellModel> getCellModel(Object obj) throws Exception {
        List<Field> list = Arrays.asList(obj.getClass().getDeclaredFields());
        List<CellModel> cellModels = new ArrayList<CellModel>();
        for (int i = 0; i < list.size(); i++) {
            Field field = list.get(i);
            //是否使用CellVal注解
            if (field.isAnnotationPresent(CellVal.class)) {
                //获得所有的注解
                for (Annotation anno : field.getDeclaredAnnotations()) {
                    //找到自己的注解
                    if (anno.annotationType().equals(CellVal.class)) {
                        CellVal cellVal = (CellVal) anno;
                        Method m = obj.getClass().getMethod(
                                "get" + getMethodName(field.getName()));
                        // 调用getter方法获取属性值
                        CellModel cellModel = new CellModel(m.invoke(obj), cellVal.row(), cellVal.col());
                        cellModels.add(cellModel);
                    }
                }

            }
        }

        if (CollectionUtils.isEmpty(cellModels)) {
            throw new InvalidParameterException("参数错误！该excel模型VO没有对应的注解！！");
        }
        return cellModels;
    }


    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }


    /**
     * 单元格model
     *
     * @param <T>
     */
    public static class CellModel<T> {

        /**
         * 单元格里的值
         */
        private T value;
        /**
         * 单元格横坐标
         */
        private int row;
        /**
         * 单元格的纵坐标
         */
        private int col;

        public CellModel() {
        }

        public CellModel(T value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }



    /**
     * 读入excel的模版流 返回Workbook对象
     *
     * @param templateInputStream
     * @param excelType
     * @return
     * @throws IOException
     */
    public static Workbook createWorkBook(InputStream templateInputStream, ExcelTypeEnum excelType) throws IOException {
        Workbook workbook;
        if (ExcelTypeEnum.XLS.equals(excelType)) {
            workbook = (templateInputStream == null) ? new HSSFWorkbook() : new HSSFWorkbook(
                    new POIFSFileSystem(templateInputStream));
        } else {
            workbook = (templateInputStream == null) ? new SXSSFWorkbook(500) : new XSSFWorkbook(templateInputStream);
        }
        return workbook;
    }

}
