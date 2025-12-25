package com.student.mapper;

import com.student.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.queryParam.UserQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author AXiao
* @description 针对表【user(用户表（系统登录）)】的数据库操作Mapper
* @createDate 2025-12-24 13:38:39
* @Entity com.student.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> list(UserQueryParam param);

    User getUsername(User user);
}




