package com.john.alltasks.common.models;

import lombok.Getter;

@Getter
public class DefaultMessage {
    
    public static String ERROR_500 = "系统内部错误，请联系管理员";

    public static String ERROR_502 = "系统内部错误，请联系管理员";

    public static String ERROR_400 = "请求异常，请联系管理员";
    
    public static String ERROR_401 = "验证失败，请联系管理员";
    
    public static String ERROR_403 = "您没有权限，请联系管理员";
    
    public static String ERROR_404 = "资源为找到，请联系管理员";

    public static String ACCOUNT_NOT_FOUND = "产品未找到，请确认产品是否存在";
    
    public static Integer SUCCESS_CODE = 0;
    
    public static String SUCCESS_MESSAGE = "success";
    
}
