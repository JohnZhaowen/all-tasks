package com.john.alltasks.common.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: zhaowen.he
 * date: 2019/11/11
 * ticket:
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {

    private boolean success;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int code;

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;


    public static ResponseData error(int code, String message){
        return new ResponseData(false, code, message);
    }


    public ResponseData(boolean success, int code, String message){
        this.success = success;
        this.message = message;
        this.code = code;
    }


    public ResponseData(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public ResponseData(boolean success, String message, T data){
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseData(boolean success, String message, T data, Long total){
        this.success = success;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public ResponseData(boolean success, String message, T data, Integer total){
        this.success = success;
        this.message = message;
        this.data = data;
        this.total = Long.parseLong(total.toString());
    }


}
