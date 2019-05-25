package com.example.messagingstompwebsocket;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); //클라이언트로 메세지를 응답해줄 때 prefix를 정의
        config.setApplicationDestinationPrefixes("/app"); // 서버에서 클라이언트로부터 메세지를 받을 api의 prefix를 설정/클라이언트에서 메세지 송신 시 붙여줄 prefix정의


    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //클라이언트에서 webSocket을 연결할 api를 설정
        //최초 소켓 연결을 하는 경우, endpoint가 되는 url, 추후 javascript에서SockJS생성자를 통해 연결될 것임
        registry.addEndpoint("/websocket").withSockJS();
    }


}
