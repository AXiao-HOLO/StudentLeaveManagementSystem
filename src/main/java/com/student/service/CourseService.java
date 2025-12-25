package com.student.service;

import com.student.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.queryParam.CourseQueryParam;
import com.student.domain.PageResult;

/**
* @author AXiao
* @description 针对表【course(课程表)】的数据库操作Service
* @createDate 2025-12-24 09:05:38
*/
public interface CourseService extends IService<Course> {

    /**
     * 分页查询课程
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    PageResult page(CourseQueryParam param);

}
