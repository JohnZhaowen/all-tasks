package com.john.alltasks.usercenter.service;

import com.john.alltasks.usercenter.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@Service("UserService")
public class UserService {
    public User findByUsername(User user){
        return new User("1", "john", "123456");
    }

    public User findUserById(String userId) {

        if(StringUtils.equals("1", userId)){
            return new User("john", "123456");
        } else {
            return null;
        }
    }

}
