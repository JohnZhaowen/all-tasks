package com.john.alltasks.common.exceptions.exception4XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;
import lombok.Getter;

/**
 * Created on 16-7-29.
 *
 * @author junjing.zhang
 */
@Getter
public class BadRequestException extends AllTasksException {


    public BadRequestException() {
        super(400, DefaultMessage.ERROR_400);
    }

    public BadRequestException(String message) {
        super(400, message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(400, message, cause);
    }
    
}
