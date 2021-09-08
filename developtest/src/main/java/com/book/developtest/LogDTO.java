package com.book.developtest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: hj
 * @date: 2021-09-08 11:13
 * @description:
 **/
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {

    /**
     * 回测id
     */
    @JsonProperty("task_id")
    private String backTestId;

    /**
     * 时间戳
     */
    @JsonProperty("timestamp")
    private String logTimestamp;

    /**
     * 日志级别
     */
    @JsonProperty("loglevel")
    private String logLevel;

    /**
     * 日志序号
     */
    @JsonProperty("logseq")
    private Integer logSeq;

    /**
     * 日志文本
     */
    @JsonProperty("logmsg")
    private String logMsg;

    /**
     * 结束标志
     */
    @JsonProperty("endflag")
    private Boolean endFlag;

    /**
     * 日志类型
     */
    @JsonProperty("logtype")
    private Integer logType;

    private static final long serialVersionUID = 1L;

}
