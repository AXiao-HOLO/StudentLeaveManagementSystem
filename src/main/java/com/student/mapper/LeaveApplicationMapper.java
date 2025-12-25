package com.student.mapper;

import com.student.domain.LeaveApplication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.queryParam.LeaveQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author AXiao
* @description 针对表【leave_application】的数据库操作Mapper
* @createDate 2025-12-24 13:37:52
* @Entity com.student.domain.LeaveApplication
*/
@Mapper
public interface LeaveApplicationMapper extends BaseMapper<LeaveApplication> {
    public List<LeaveApplication> selectLeaveApplication(LeaveQueryParam param);
}




