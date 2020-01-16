package com.john.alltasks.common.exceptions.exception4XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;

public class ResourceNotFoundException extends AllTasksException {

    public ResourceNotFoundException() {
        super(404, DefaultMessage.ERROR_404);
    }

    public ResourceNotFoundException(String message) {
        super(404, message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(404, message, cause);
    }
    
}
