package com.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Long id; //ID
    private String username; //用户名
    private String name; //姓名
    private Integer type; //用户类型
    private String token; //令牌
}

