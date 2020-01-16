package com.john.alltasks.warning.exceptions;

import com.john.alltasks.common.exceptions.bizException.BizException;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
public class EmailWarnException extends BizException {

    public EmailWarnException(int code, String message) {
        super(code, message);
    }

    public EmailWarnException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
