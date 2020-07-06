///**
// * 通联数据机密
// * --------------------------------------------------------------------
// * 通联数据股份公司版权所有 © 2013-2019
// * <p>
// * 注意：本文所载所有信息均属于通联数据股份公司资产。本文所包含的知识和技术概念均属于
// * 通联数据产权，并可能由中国、美国和其他国家专利或申请中的专利所覆盖，并受商业秘密或
// * 版权法保护。
// * 除非事先获得通联数据股份公司书面许可，严禁传播文中信息或复制本材料。
// * <p>
// * DataYes CONFIDENTIAL
// * --------------------------------------------------------------------
// * Copyright © 2013-2019 DataYes, All Rights Reserved.
// * <p>
// * NOTICE: All information contained herein is the property of DataYes
// * Incorporated. The intellectual and technical concepts contained herein are
// * proprietary to DataYes Incorporated, and may be covered by China, U.S. and
// * Other Countries Patents, patents in process, and are protected by trade
// * secret or copyright law.
// * Dissemination of this information or reproduction of this material is
// * strictly forbidden unless prior written permission is obtained from DataYes.
// */
//
//package com.john.alltasks.common.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.session.SessionAuthenticationException;
//
///**
// * Created by junjing.zhang on 16/9/21.
// */
//public class AuthUtil {
//    private static ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();
//
//    public static String getUserId() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (null == auth || null == auth.getName()) {
//            String userId = userIdThreadLocal.get();
//            if (userId != null) {
//                return userId;
//            } else {
//                userId = "admin.yzcx@yzcx.com";
//                setUserId(userId);
//                return userId;
////                throw new SessionAuthenticationException("用户未登录");
//            }
//        }
//        return auth.getName();
//    }
//
//    public static void setUserId(String userId) {
//        if (userId == null) {
//            userIdThreadLocal.remove();
//        } else {
//            userIdThreadLocal.set(userId);
//        }
//    }
//
//    public static String getTenant() {
//        String user = getUserId();
//        return getTenant(user);
//    }
//
//    public static String getTenantByNoThrow() {
//        try {
//            String user = getUserId();
//            return getTenant(user);
//        }catch (SessionAuthenticationException e){
//            return null;
//        }
//    }
//
//    public static String getTenant(String user) {
//        if (null == user) {
//            throw new SessionAuthenticationException("用户未登录");
//        }
//        String[] userArr = user.split("@");
//        if (userArr == null || userArr.length != 2) {
//            throw new SessionAuthenticationException("用户解析失败");
//        }
//        return userArr[1];
//    }
//
//    public static boolean isTenantMatch(String user) {
//        String invokerTenant = getTenant();
//        String userTenant = getTenant(user);
//
//        return invokerTenant.equals(userTenant);
//    }
//
//}
