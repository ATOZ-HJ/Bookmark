package com.bookmark.pdf.exceltopdf.util.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.bookmark.pdf.exceltopdf.util.annotation.CellVal;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: hj
 * @DateTime: 2020/11/20 14:07
 * @Description: 入库单  导出excel封装
 */
@Data
public class GoldInStoreExcel {

    @CellVal(row = 4,col = 2)
    private String customerName;

    @ExcelProperty("入库仓")
    private String departmentName;

    @ExcelProperty("入库日期")
    private Date inStoreTime;

    @ExcelProperty("入库单号")
    private String inId;

    @ExcelProperty("金额合计")
    private BigDecimal totalReferenceMoney;

    @ExcelProperty("重量合计")
    private BigDecimal totalWeight;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("制单人")
    private String createrName;

    @ExcelProperty("收货人")
    private String receiver;

    @ExcelProperty("品控人")
    private String qualityController;

    @ExcelProperty("财务")
    private String financialOfficer;

    @ExcelProperty("客户")
    private String customer;

}
