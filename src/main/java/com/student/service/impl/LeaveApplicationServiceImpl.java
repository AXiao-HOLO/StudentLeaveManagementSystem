package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.domain.LeaveApplication;
import com.student.domain.PageResult;
import com.student.domain.Student;
import com.student.domain.queryParam.LeaveQueryParam;
import com.student.service.LeaveApplicationService;
import com.student.mapper.LeaveApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author AXiao
* @description 针对表【leave_application】的数据库操作Service实现
* @createDate 2025-12-24 13:37:52
*/
@Service
public class LeaveApplicationServiceImpl extends ServiceImpl<LeaveApplicationMapper, LeaveApplication>
    implements LeaveApplicationService{

    @Autowired
    private LeaveApplicationMapper leaveApplicationMapper;

    @Override
    public PageResult page(LeaveQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<LeaveApplication> list = leaveApplicationMapper.selectLeaveApplication(param);
        PageInfo<LeaveApplication> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}




