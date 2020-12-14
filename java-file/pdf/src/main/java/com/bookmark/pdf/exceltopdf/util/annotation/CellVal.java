package com.bookmark.pdf.exceltopdf.util.annotation;


import java.lang.annotation.*;

/**
 * @Author laixiaoxing
 * @Description excel单元格填充的注解
 * @Date 上午12:45 2019/2/18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface CellVal {

    /**
     * 单元格横坐标
     */
    int row();

    /**
     * 单元格的纵坐标
     */
    int col();
}
