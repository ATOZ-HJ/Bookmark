package com.bookmark.websocket.pojo;

import lombok.Data;

/**
 * @Author: hj
 * @DateTime: 2020/10/28 14:15
 * @Description:
 */
@Data
public class MessageBody {
    /** 消息内容 */
    private String content;
    /** 广播转发的目标地址（告知 STOMP 代理转发到哪个地方） */
    private String destination;
}
