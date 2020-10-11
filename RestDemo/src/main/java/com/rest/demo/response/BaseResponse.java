package com.rest.demo.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse implements Serializable {

    Boolean success;
    String msg;
    Object result;

    public static BaseResponse success(String msg, Object result) {
        return new BaseResponse(true, msg, result);
    }

    public static BaseResponse fail(String msg, Object result) {
        return new BaseResponse(false, msg, result);
    }
}