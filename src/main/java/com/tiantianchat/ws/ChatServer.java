package com.tiantianchat.ws;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/chat-server")
@Component
public class ChatServer {

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }
}
