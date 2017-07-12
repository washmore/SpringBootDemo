package tech.washmore.demo.springboot.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Washmore
 * @version V1.0
 * @summary ServerEndpoint
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/7/12
 */
@ServerEndpoint("/webSocket")
@Component
public class WebSocketEndPoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEndPoint.class);
    private static Map<String, Session> connectClients = new HashMap<>();

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        LOGGER.info("Received msg from {}:{}", session.getId(), message);

        connectClients.forEach((k, v) -> {
            if (!k.equals(session.getId())) {
                v.getAsyncRemote().sendText(String.format("收到来自 %s 的消息:%s", session.getId(), message));
            }
        });
    }

    @OnOpen
    public void onOpen(Session session) {
        connectClients.forEach((k, v) -> {
            v.getAsyncRemote().sendText(String.format("欢迎 %s 进入!", session.getId()));
        });
        connectClients.put(session.getId(), session);
        LOGGER.info("Client connected-id:{}", session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        connectClients.remove(session.getId());
        connectClients.forEach((k, v) -> {
            v.getAsyncRemote().sendText(String.format("%s 伤心的离开了我们!", session.getId()));
        });
        LOGGER.info("Connection closed-id:{}", session.getId());
    }
}
