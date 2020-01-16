package com.john.alltasks.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@Slf4j
public class ValidationUtil {

    public static boolean validParam(BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                log.error("校验失败字段: [{}], 校验失败原因: [{}]", fieldError.getField(), fieldError.getDefaultMessage());
            });
            return false;
        } else {
            return true;
        }
    }

}
