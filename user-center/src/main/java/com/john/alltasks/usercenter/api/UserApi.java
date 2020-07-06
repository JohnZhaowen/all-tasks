package com.john.alltasks.usercenter.api;

import com.john.alltasks.common.models.ResponseData;
import com.john.alltasks.usercenter.annotation.UserLoginToken;
import com.john.alltasks.usercenter.entity.User;
import com.john.alltasks.usercenter.service.TokenService;
import com.john.alltasks.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John_He
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    //登录
    @PostMapping("/login")
    public ResponseData login(@RequestBody User user){

        ResponseData responseData = new ResponseData();
        responseData.setStatus("ok");
        responseData.setCurrentAuthority("guest");
        responseData.setSuccess(true);
        return responseData;

        /*User userForBase = userService.findByUsername(user);
        if(userForBase == null){
            return "登录失败,用户不存在";

        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                return "登录失败,密码错误";
            }else {
                String token = tokenService.getToken(userForBase);
                Map<String, Object> result = new HashMap<>();
                result.put("token", token);
                result.put("user", userForBase);
                return result;
            }
        }*/
    }
    
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
