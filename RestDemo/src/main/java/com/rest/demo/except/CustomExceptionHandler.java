package com.rest.demo.except;

import com.rest.demo.response.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Set;

/*
* 这个必须有，用于声明是对 controller 控制器的增强。
* */
@ControllerAdvice
public class CustomExceptionHandler {

    // 自定义错误01响应处理
    @ExceptionHandler({CustomException01.class,})
    public ResponseEntity<Object> handleCustomException01Exception(CustomException01 ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(BaseResponse.fail("CustomException01异常", null), HttpStatus.BAD_REQUEST);
    }

    // 自定义错误02响应处理
    @ExceptionHandler({CustomException02.class,})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final BaseResponse handleCustomException02Exception(CustomException02 ex, WebRequest request) throws Exception {
        return BaseResponse.fail("CustomException02异常", null);
    }
}