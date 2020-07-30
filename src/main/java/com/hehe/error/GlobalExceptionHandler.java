package com.hehe.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Map bizExceptionHandler(DefinitionException e) {
        Map map = new HashMap();
        map.put("code",e.getErrorCode());
        map.put("message",e.getErrorMsg());
        return map;
    }

    /**
     * 处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map exceptionHandler( Exception e) {
        Map map = new HashMap();
        map.put("code",e.getCause());
        map.put("message",e.getMessage());
        return map;
    }
}
