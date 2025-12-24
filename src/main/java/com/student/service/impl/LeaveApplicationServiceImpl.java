package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.LeaveApplication;
import com.student.service.LeaveApplicationService;
import com.student.mapper.LeaveApplicationMapper;
import org.springframework.stereotype.Service;

/**
* @author AXiao
* @description 针对表【leave_application】的数据库操作Service实现
* @createDate 2025-12-24 13:37:52
*/
@Service
public class LeaveApplicationServiceImpl extends ServiceImpl<LeaveApplicationMapper, LeaveApplication>
    implements LeaveApplicationService{

}




