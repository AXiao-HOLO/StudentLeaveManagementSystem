package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Course;
import com.student.service.CourseService;
import com.student.mapper.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author AXiao
* @description 针对表【course(课程表)】的数据库操作Service实现
* @createDate 2025-12-24 09:05:38
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

}




