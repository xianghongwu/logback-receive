package com.xhw.logbackreceive.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Auther: xhw
 * @Date: 2019-09-26 11:29
 * @Description:开启WebSocket支持
 */
@Configuration
public class WebSocketConfig {

    /*
    * 如果tomcat部署一直报这个错，注请移除 WebSocketConfig 中@Bean ServerEndpointExporter 的入 。

      ServerEndpointExporter 是由Spring官方提供的标准实现，用于扫描ServerEndpointConfig配置类和@ServerEndpoint注解实例。使用规则也很简单：

      如果使用默认的嵌入式容器 比如Tomcat 则必须手工在上下文提供ServerEndpointExporter。
      如果使用外部容器部署war包，则不需要提供提供ServerEndpointExporter，因为此时SpringBoot默认将扫描服务端的行为交给外部容器处理，所以线上部署的时候要把WebSocketConfig中这段注入bean的代码注掉。
    *
    *
    *
    *
     * 用途：扫描并注册所有携带@ServerEndpoint注解的实例。 @ServerEndpoint("/websocket")
     * PS：如果使用外部容器 则无需提供ServerEndpointExporter。
     *
    * */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 支持注入其他类
     */
    @Bean
    public MyEndpointConfigure  newMyEndpointConfigure (){
        return new MyEndpointConfigure ();
    }
}
