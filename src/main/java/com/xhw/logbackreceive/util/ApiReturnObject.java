package com.xhw.logbackreceive.util;

/**
 * @Auther: xhw
 * @Date: 2019-09-26 14:16
 * @Description:
 */
public class ApiReturnObject {

    private Integer code;

    private String message;

    private Object data;


    public static ApiReturnObject error(String msg){

        ApiReturnObject apiReturnObject=new ApiReturnObject();
        apiReturnObject.setCode(500);
        apiReturnObject.setMessage(msg);
        return apiReturnObject;
    }

    public static ApiReturnObject success(String msg){

        ApiReturnObject apiReturnObject=new ApiReturnObject();
        apiReturnObject.setCode(200);
        apiReturnObject.setMessage(msg);
        return apiReturnObject;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
