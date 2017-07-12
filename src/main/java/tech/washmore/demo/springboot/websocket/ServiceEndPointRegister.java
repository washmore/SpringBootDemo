package tech.washmore.demo.springboot.websocket;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Washmore
 * @version V1.0
 * @summary  用于注册使用@ServiceEndpoint注解的类为websocket容器 如果使用tomcat7+等容器,则不需要配额制此bean
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/7/12
 */
@Configuration
@ConditionalOnWebApplication
public class ServiceEndPointRegister extends WebMvcConfigurerAdapter {
    /**
     * @return
     * @doc http://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/reference/htmlsingle/#boot-features-websockets
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /*
    If you want to use @ServerEndpoint in a Spring Boot application that used an embedded container, you must declare a single ServerEndpointExporter @Bean:
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
        }
    This bean will register any @ServerEndpoint annotated beans with the underlying WebSocket container. When deployed to a standalone servlet container this role is performed by a servlet container initializer and the ServerEndpointExporter bean is not required.
     */
}
