package com.student.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.student.domain.LoginInfo;
import com.student.domain.Result;
import com.student.domain.Student;
import com.student.domain.User;
import com.student.service.StudentService;
import com.student.service.UserService;
import com.student.util.BCryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("用户 {} 来登录啦", user.getUsername());
        LoginInfo loginInfo = userService.login(user);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误~");
    }

    // 注册
    @PutMapping
    public Result register(@RequestBody User user) {
        log.info("用户 {} 来注册啦", user.getUsername());
        // 检查用户名是否已存在
        if(userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())) != null){
            return Result.error("用户名已存在~");
        }
        // 如果用户输入的学号不存在，注册失败
        if(studentService.getOne(Wrappers.<Student>lambdaQuery().eq(Student::getStudentNo, user.getStudentNo())) == null){
            return Result.error("学号不存在~");
        }
        // 如果用户输入的学号与姓名不匹配，注册失败
        if(!studentService.getOne(Wrappers.<Student>lambdaQuery().eq(Student::getStudentNo, user.getStudentNo())).getName().equals(user.getName())){
            return Result.error("学号与姓名不匹配~");
        }
        // 设置用户类型为学生
        user.setUserType(1);
        // 设置密码为加密后的密码
        user.setPassword(BCryptUtil.encryptPassword(user.getPassword()));

        boolean b = userService.save(user);
        if(b){
            return Result.success();
        }
        return Result.error("注册失败~");
    }

    // 重置密码
    @PostMapping("/reset-password")
    public Result resetPassword(@RequestBody User user) {
        log.info("用户 {} 来重置密码啦", user.getUsername());
        user.setUpdateTime(LocalDateTime.now());
        // 检查用户名是否存在
        if(userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())) == null){
            return Result.error("用户名不存在~");
        }
        // 检验用户名是否与姓名匹配
        if(!userService.selectByUsername(user.getUsername()).getName().equals(user.getName())){
            return Result.error("用户名与姓名不匹配~");
        }
        // 检验学号是否与姓名匹配
        if(!studentService.getInfoByName(user.getName()).getStudentNo().equals(user.getStudentNo())){
            return Result.error("学号与姓名不匹配~");
        }
        // 设置新密码为加密后的密码
        user.setPassword(BCryptUtil.encryptPassword(user.getPassword()));
        // 获取旧用户信息
        User oldUser = userService.selectByUsername(user.getUsername());
        // 更新用户密码
        oldUser.setPassword(user.getPassword());
        boolean b = userService.updateById(oldUser);
        if(b){
            return Result.success();
        }
        return Result.error("重置密码失败~");
    }
}
