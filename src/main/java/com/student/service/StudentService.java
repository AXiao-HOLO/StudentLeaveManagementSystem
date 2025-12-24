package com.student.service;

import com.student.domain.PageResult;
import com.student.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.domain.StuQueryParam;

import java.util.List;

/**
* @author AXiao
* @description 针对表【student(学生表)】的数据库操作Service
* @createDate 2025-12-24 13:37:46
*/
public interface StudentService extends IService<Student> {

    /**
     * 分页查询学生
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    PageResult page(StuQueryParam param);
    
    /**
     * 删除学生
     *
     * @param ids 学生id列表
     * @return 删除结果
     */
    boolean deleteByIds(List<Integer> ids);

    Student getInfo(Integer id);
}
