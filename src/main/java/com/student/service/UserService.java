package com.student.service;

import com.student.domain.LoginInfo;
import com.student.domain.PageResult;
import com.student.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.queryParam.UserQueryParam;

/**
* @author AXiao
* @description 针对表【user(用户表（系统登录）)】的数据库操作Service
* @createDate 2025-12-24 13:38:39
*/
public interface UserService extends IService<User> {

    /**
     * 分页查询用户
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    PageResult page(UserQueryParam param);

    LoginInfo login(User user);

    Integer getTypeById(Integer id);
}
