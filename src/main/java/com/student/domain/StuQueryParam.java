package com.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private Long id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 所属班级ID
     */
    private Long classId;

    /**
     * 性别：1-男，2-女
     */
    private Integer gender;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 学生邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private String className;
}
