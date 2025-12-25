package com.student.service;

import com.student.domain.LeaveApplication;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.queryParam.LeaveQueryParam;

/**
* @author AXiao
* @description 针对表【leave_application】的数据库操作Service
* @createDate 2025-12-24 13:37:52
*/
public interface LeaveApplicationService extends IService<LeaveApplication> {
    /**
     * 分页查询请假申请
     * @param param 查询参数
     * @return 请假申请分页结果
     */
    com.student.domain.PageResult page(LeaveQueryParam param);
}
