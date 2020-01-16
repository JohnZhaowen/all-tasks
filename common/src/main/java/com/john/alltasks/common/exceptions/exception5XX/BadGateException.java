package com.john.alltasks.common.exceptions.exception5XX;

import com.john.alltasks.common.exceptions.AllTasksException;
import com.john.alltasks.common.models.DefaultMessage;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
public class BadGateException extends AllTasksException {


    public BadGateException() {
        super(502, DefaultMessage.ERROR_502);
    }

    public BadGateException(String message) {
        super(502, message);
    }

    public BadGateException(String message, Throwable cause) {
        super(502, message, cause);
    }
}
