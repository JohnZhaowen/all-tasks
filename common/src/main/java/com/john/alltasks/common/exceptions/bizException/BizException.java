package com.john.alltasks.common.exceptions.bizException;

import com.john.alltasks.common.exceptions.AllTasksException;

/**
 *
 * 业务代码错误信息统一返回
 * <p>
 *  HTTP code 200
 * </p>
 *
 *
 */
public class BizException extends AllTasksException {

    public BizException(int code, String message) {
        super(code, message);
    }

    public BizException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
