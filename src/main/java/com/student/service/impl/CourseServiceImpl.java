package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.domain.*;
import com.student.domain.queryParam.CourseQueryParam;
import com.student.service.CourseService;
import com.student.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author AXiao
* @description 针对表【course(课程表)】的数据库操作Service实现
* @createDate 2025-12-24 09:05:38
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageResult page(CourseQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Course> list = courseMapper.list(param);
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}




