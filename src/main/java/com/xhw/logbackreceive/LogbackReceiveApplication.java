package com.xhw.logbackreceive;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xhw.logbackreceive.entity.Logback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class LogbackReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogbackReceiveApplication.class, args);
	}
	/**
	 * 配置内部类
	 */
	@Controller
	@Configuration
	class Config {

		/**
		 * 获取日志对象，构造函数传入当前类，查找日志方便定位
		 */
		private final Logger logger = LoggerFactory.getLogger(this.getClass());

		@Value("${user.dir}")
		private String userName;

		/**
		 * 端口
		 */
		@Value("${server.port}")
		private String port;
		/**
		 * 启动成功
		 */
		@Bean
		public ApplicationRunner applicationRunner() {
			return applicationArguments -> {
				try {
					InetAddress ia = InetAddress.getLocalHost();
					//获取本机内网IP
					logger.info("启动成功：" + "http://" + ia.getHostAddress() + ":" + port + "/");
					logger.info("${user.dir} ：" + userName);
				} catch (UnknownHostException ex) {
					ex.printStackTrace();
				}
			};
		}

		/**
		 * 跳转实时日志
		 */
		@GetMapping("/logging")
		public ModelAndView logging() {
			return new ModelAndView("logging");
		}
	}
}
