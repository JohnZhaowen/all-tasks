package com.john.alltasks.datasource.config;

import com.john.alltasks.common.exceptions.bizException.BizException;
import com.john.alltasks.common.exceptions.exception4XX.BadRequestException;
import com.john.alltasks.common.exceptions.exception4XX.ForbiddenException;
import com.john.alltasks.common.exceptions.exception4XX.ResourceNotFoundException;
import com.john.alltasks.common.exceptions.exception4XX.UnauthorizedException;
import com.john.alltasks.common.exceptions.exception5XX.InternalErrorException;
import com.john.alltasks.common.models.ResponseData;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseData handleBadRequestException(BadRequestException ex) {
        log.error("BadRequestException: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 业务Exception
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseData handleMomException(BizException ex) {
        log.error("BizException: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 401
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    public ResponseData handleUnauthorizedException(UnauthorizedException ex) {
        log.error("UnauthorizedException: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 403
     * @return
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({ForbiddenException.class})
    public ResponseData handleForbiddenException(ForbiddenException ex) {
        log.error("ForbiddenException: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseData handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({InternalErrorException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData handleInternalServerError(InternalErrorException ex) {
        log.error("InternalServerError: ", ex);
        return ResponseData.error(ex.getCode(), ex.getMessage());

    }

    @ResponseBody
    @ExceptionHandler({Throwable.class, Exception.class, RuntimeException.class, InternalException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData handleInternalServerError(Throwable ex) {
        log.error("InternalServerError: ", ex);
        return ResponseData.error(500, ex.getMessage());
    }
}
