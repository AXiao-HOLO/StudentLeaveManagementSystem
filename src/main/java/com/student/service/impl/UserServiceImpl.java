package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.domain.PageResult;
import com.student.domain.Student;
import com.student.domain.User;
import com.student.domain.queryParam.UserQueryParam;
import com.student.service.UserService;
import com.student.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}




