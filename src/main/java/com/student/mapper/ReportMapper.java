package com.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReportMapper extends BaseMapper<OperateLog> {

    // 返回所有操作日志
    @Select("select * from operate_log")
    List<OperateLog> list();
}
