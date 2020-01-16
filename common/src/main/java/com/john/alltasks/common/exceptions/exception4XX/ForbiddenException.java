package com.john.alltasks.common.exceptions.exception4XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;

public class ForbiddenException extends AllTasksException {

    public ForbiddenException() {
        super(403, DefaultMessage.ERROR_403);
    }

    public ForbiddenException(String message) {
        super(403, message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(403, message, cause);
    }

}
