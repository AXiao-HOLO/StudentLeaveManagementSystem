package com.student.controller;

import com.student.domain.LoginInfo;
import com.student.domain.Result;
import com.student.domain.User;
import com.student.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("员工来登录啦 , {}", user);
        LoginInfo loginInfo = userService.login(user);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误~");
    }
}
