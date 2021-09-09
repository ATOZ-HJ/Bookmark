package com.book.developtest;

import lombok.Data;

/**
 * @author: hj
 * @date: 2021-09-08 11:13
 * @description:
 **/
@Data
public class LogDTO {

    /**
     * 回测id
     */
    // @JsonProperty("task_id")
    private String backTestId;

    /**
     * 时间戳
     */
    // @JsonProperty("timestamp")
    private String timestamp;

    /**
     * 日志级别
     */
    // @JsonProperty("loglevel")
    private String loglevel;

    /**
     * 日志序号
     */
    // @JsonProperty("logseq")
    private Integer logseq;

    /**
     * 日志文本
     */
    // @JsonProperty("logmsg")
    private String logmsg;

    /**
     * 结束标志
     */
    // @JsonProperty("endflag")
    private Boolean endflag;

    /**
     * 日志类型
     */
    // @JsonProperty("logtype")
    private Integer logtype;

    private static final long serialVersionUID = 1L;

}
