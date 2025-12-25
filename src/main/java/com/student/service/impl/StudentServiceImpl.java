package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.domain.PageResult;
import com.student.domain.Student;
import com.student.domain.queryParam.StuQueryParam;
import com.student.service.StudentService;
import com.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AXiao
 * @description 针对表【student(学生表)】的数据库操作Service实现
 * @createDate 2025-12-24 13:37:46
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult page(StuQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Student> list = studentMapper.list(param);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
        return true;
    }

     @Override
    public Student getInfo(Integer id) {
        return studentMapper.selectById(id);
    }

}




