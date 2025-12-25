package com.student.domain.queryParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数

    private Long id;

    /**
     * 学生学号
     */
    private Long studentId;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 请假类型（病假，事假，公假）
     */
    private String leaveType;

    /**
     * 请假事由
     */
    private String reason;

    /**
     * 审批状态（0-待批阅 1-已通过 2-已驳回）
     */
    private Integer status;

    /**
     * 申请时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 审批备注
     */
    private String approveRemark;

    private String studentName;
    private String studentNo;
    private String className;
}
