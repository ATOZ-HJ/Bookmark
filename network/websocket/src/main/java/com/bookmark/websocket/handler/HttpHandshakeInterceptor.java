package com.bookmark.websocket.handler;

import com.bookmark.websocket.pojo.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: hj
 * @DateTime: 2020/10/28 15:43
 * @Description:
 */
public class HttpHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        // 将 request 对象转换为 ServletServerHttpRequest 对象
        ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
        // 获取 HTTP Session 对象
        HttpSession session = serverRequest.getServletRequest().getSession();
        User userInfo = new User();
        userInfo.setPassword("123412");
        userInfo.setSex("0");
        userInfo.setUsername("123123");
        userInfo.setName("user");
        session.setAttribute("user", userInfo);
        if (session != null) {
            // 从 HTTP Session 中获取用户信息
            User user = (User) session.getAttribute("user");
            if (user != null) {
                // 将从 HTTP Session 中获取的用户信息存入 WebSocket 的 Attributes 对象中
                attributes.put("user", user);
                // 继续握手
                return true;
            }
        }
        // 终止握手
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
