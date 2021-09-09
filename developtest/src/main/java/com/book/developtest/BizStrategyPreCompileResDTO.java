package com.book.developtest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hj
 * @date: 2021-08-24 14:29
 * @description: 策略预编译结果参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BizStrategyPreCompileResDTO {
    /**
     * 任务id(策略id)
     */
    private String taskId;

    private String strategyId;

    private String status;

    private String info;

    /**
     * 进程，根据py实现方式，当进程为1的时候，说明编译完成了
     */
    private String progress;

    /**
     * 0预编译成功，1预编译失败
     */
    private String retCode;

    /**
     * 失败信息
     */
    private String retMsg;

    /**
     * 回测参数
     */
    private String varietyList;

    /**
     * 策略参数
     */
    private String parameters;
}
