package com.john.alltasks.usercenter.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.john.alltasks.usercenter.entity.User;
import org.springframework.stereotype.Service;


/**
 * @author John_He
 */
@Service
public class TokenService {
    public String getToken(User user) {
        String token = JWT.create().withAudience(user.getId())//将 userId 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));//以 password 作为 token 的密钥
        return token;
    }
}
