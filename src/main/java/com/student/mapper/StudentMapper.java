package com.student.mapper;

import com.student.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.domain.queryParam.StuQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author AXiao
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2025-12-24 13:37:46
* @Entity com.student.domain.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    public List<Student> list(StuQueryParam param);
}




