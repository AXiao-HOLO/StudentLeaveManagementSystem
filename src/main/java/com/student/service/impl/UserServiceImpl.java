package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.domain.LoginInfo;
import com.student.domain.PageResult;
import com.student.domain.Student;
import com.student.domain.User;
import com.student.domain.queryParam.UserQueryParam;
import com.student.service.UserService;
import com.student.mapper.UserMapper;
import com.student.util.BCryptUtil;
import com.student.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author AXiao
* @description 针对表【user(用户表（系统登录）)】的数据库操作Service实现
* @createDate 2025-12-24 13:38:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public PageResult page(UserQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<User> list = userMapper.list(param);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public LoginInfo login(User user) {
        User userLogin = userMapper.getUsername(user);
        if(userLogin == null){
            return null;
        }
        if(BCryptUtil.checkPassword(user.getPassword(), userLogin.getPassword())){
            //1. 生成JWT令牌
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id", userLogin.getId());
            dataMap.put("username", userLogin.getUsername());
            dataMap.put("type", userLogin.getUserType());

            String jwt = JwtUtil.generateJwt(dataMap);
            return new LoginInfo(userLogin.getId(), userLogin.getUsername(), userLogin.getName(), userLogin.getUserType(), jwt);
        }
        return null;
    }

    @Override
    public Integer getTypeById(Integer id) {
        return userMapper.selectById(id).getUserType();
    }
}




