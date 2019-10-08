package com.xhw.logbackreceive.entity;

import org.slf4j.MDC;
import org.springframework.boot.logging.LogLevel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: xhw
 * @Date: 2019-09-20 14:17
 * @Description:
 */
public class Logback {

    private String timestamp;
    private LogLevel level;
    private String thread;
    private String logger;
    private String message;
    private String context;
    private String exception="";


    @Override
    public String toString() {
        String str="";
        String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(Long.valueOf(timestamp)));
        str= "\n"+strn+"   "+String.valueOf(level)+"  ---- ["+thread+"]   "+logger+":   "+message+"\n"+(exception==null?"":exception);
        return str;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
