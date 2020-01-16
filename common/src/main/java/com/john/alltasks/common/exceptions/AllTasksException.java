package com.john.alltasks.common.exceptions;

import lombok.Getter;


public abstract class AllTasksException extends RuntimeException {
    
    @Getter
    private Integer code;

    public AllTasksException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public AllTasksException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
