package com.example.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : nakgyeom
 * @date : 2023-02-08 오후 3:47
 */
@Slf4j
@Component
public class ChatHandler extends TextWebSocketHandler { // 텍스트 기반의 채팅을 구현할 것이기에 TextWebSocketHandler를 재정의

    private static final List<WebSocketSession> list = new ArrayList<>();

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session + "클라이언트 접속");
        list.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload: " + payload);

        for (WebSocketSession sess : list) {
            sess.sendMessage(message);
        }
    }

    /* Client가 접속 해제 시 호출되는 메서드 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + "클라이언트 접속 해제");
        list.remove(session);
    }
}
