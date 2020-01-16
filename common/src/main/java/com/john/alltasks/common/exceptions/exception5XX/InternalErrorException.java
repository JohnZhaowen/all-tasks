package com.john.alltasks.common.exceptions.exception5XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;

/**
 * 魔方代码内部错误
 * <p>
 *  HTTP code 500
 * </p>
 */
public class InternalErrorException extends AllTasksException {


    public InternalErrorException() {
        super(500, DefaultMessage.ERROR_500);
    }

    public InternalErrorException(String message) {
        super(500, message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(500, message, cause);
    }
    
}