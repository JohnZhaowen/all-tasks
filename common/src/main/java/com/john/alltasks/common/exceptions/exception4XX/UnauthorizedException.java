package com.john.alltasks.common.exceptions.exception4XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;

public class UnauthorizedException extends AllTasksException {

    public UnauthorizedException() {
        super(401, DefaultMessage.ERROR_401);
    }

    public UnauthorizedException(String message) {
        super(401, message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(401, message, cause);
    }

}
