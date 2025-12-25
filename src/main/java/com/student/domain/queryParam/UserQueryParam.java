package com.student.domain.queryParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数

    private Long id;

    /**
     * 用户名（登录账号，如学号/工号）
     */
    private String username;

    /**
     * 密码（加密存储，如BCrypt加密）
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类型：1-学生，2-辅导员
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
