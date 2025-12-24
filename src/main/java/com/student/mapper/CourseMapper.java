package com.student.mapper;

import com.student.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author AXiao
* @description 针对表【course(课程表)】的数据库操作Mapper
* @createDate 2025-12-24 09:05:38
* @Entity com.student.domain.Course
*/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}




