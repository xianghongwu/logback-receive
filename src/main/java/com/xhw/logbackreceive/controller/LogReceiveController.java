package com.xhw.logbackreceive.controller;

import com.alibaba.fastjson.JSON;
import com.xhw.logbackreceive.entity.Logback;
import org.apache.logging.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: xhw
 * @Date: 2019-09-24 15:03
 * @Description:
 */
@RestController
public class LogReceiveController {


    private final static Logger logger = LoggerFactory.getLogger(LogReceiveController.class);

    @RequestMapping("logtest/{projectName}")
    public void logtest(@PathVariable(value = "projectName") String projectName,HttpServletRequest httpServletRequest){
        MDC.put("projectId",projectName);

        BufferedReader bufferedReader = null;
        String str, wholeStr = "[";
        try {
            bufferedReader = httpServletRequest.getReader();
            while((str = bufferedReader.readLine()) != null) {
                wholeStr += str;
            }
            wholeStr+="]";
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Logback> logbackList = JSON.parseArray(wholeStr, Logback.class);
        for (Logback parseObject : logbackList) {
            String s = parseObject.toString();
            //System.out.println(s+"**************************");
            switch (parseObject.getLevel()){
                case TRACE:
                    logger.trace(s);
                    break;
                case DEBUG :
                    logger.debug(s);
                    break;
                case INFO:
                    logger.info(s);
                    break;
                case WARN:
                    logger.warn(s);
                    break;
                case ERROR:
                    logger.error(s);
                    break;
            }
        }
        MDC.remove("projectId");
    }
}
