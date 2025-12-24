package com.student.controller;

import com.student.domain.PageResult;
import com.student.domain.Result;
import com.student.domain.StuQueryParam;
import com.student.domain.Student;
import com.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author AXiao
 * @description 学生表接口
 * @createDate 2025-12-24 09:05:29
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StuController {
    @Autowired
    private StudentService studentService;

    /**
     * 学生列表
     *
     * @return 学生列表
    @GetMapping
    public Result list() {
        log.info("学生列表");
        List<Student> list = studentService.list();
        return Result.success(list);
    }*/
    /**
     * 分页查询学生
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(StuQueryParam param) {
        log.info("分页查询学生：{}", param);
        PageResult pageResult = studentService.page(param);
        return Result.success(pageResult);

    }

    /**
     * 删除学生
     *
     * @param ids 学生id列表
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("删除学生：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
     /**
     * 保存学生
     *
     * @param student 学生对象
     * @return 保存结果
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
       log.info("保存学生：{}", student);
       studentService.saveOrUpdate(student);
       return Result.success(student);
    }

     /**
     * 获取学生信息
     *
     * @param id 学生id
     * @return 学生信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@RequestParam Integer id) {
        log.info("获取学生信息：{}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

     /**
     * 更新学生信息
     *
     * @param student 学生对象
     * @return 更新结果
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("更新学生信息：{}", student);
        studentService.saveOrUpdate(student);
        return Result.success();
    }
}
