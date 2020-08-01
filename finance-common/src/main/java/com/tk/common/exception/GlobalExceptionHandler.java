package com.tk.common.exception;

import com.tk.common.result.CommonResult;
import com.tk.common.result.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;


/**
 * @author kzc
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        if(e instanceof  org.springframework.web.servlet.NoHandlerFoundException)
        {
            return CommonResult.validateFailed();
        }else if(e instanceof BindException){
            return CommonResult.failed(ResultCode.PARAMETER_ERR);
        }
        return CommonResult.failed();
    }
}
