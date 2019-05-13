package cn.zwuyang.validatordemo.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常拦截
 * @author wuyang
 **/
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    /**
     * 处理实体校验
     **/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handlerException(MethodArgumentNotValidException ex) {
        StringBuffer errorInfo=new StringBuffer();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        for(int i=0; i<errors.size(); i++){
            errorInfo.append(errors.get(i).getDefaultMessage()+",");
        }

        LOGGER.error(errorInfo.toString());

        return errorInfo.toString();
    }

    /**
     * 处理字段校验
     **/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handlerException(ConstraintViolationException ex) {

        StringBuffer errorInfo=new StringBuffer();
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();

        errors.forEach(error -> errorInfo.append(error.getMessageTemplate()+","));

        LOGGER.error(errorInfo.toString());

        return errorInfo.toString();
    }
}
