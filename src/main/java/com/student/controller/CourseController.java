package com.student.controller;

import com.student.anno.LogOperation;
import com.student.domain.*;
import com.student.domain.queryParam.CourseQueryParam;
import com.student.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

/*    *//**
     * 课程列表
     *
     * @return 课程列表
     *//*
    @GetMapping
    public Result list() {
        log.info("课程列表");
        List<Course> list = courseService.list();
        return Result.success(list);
    }*/

    /**
     * 分页查询课程
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(CourseQueryParam param) {
        log.info("分页查询课程：{}", param);
        PageResult pageResult = courseService.page(param);
        return Result.success(pageResult);
    }
     /**
      * 更新课程
      *
      * @param course 课程信息
      * @return 更新结果
      */
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Course course) {
        log.info("更新课程：{}", course);
        boolean b = courseService.updateById(course);
        if (b) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }
    }

     /**
      * 删除课程
      *
      * @param id 课程id
      * @return 删除结果
      */
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除课程：{}", id);
        boolean b = courseService.removeById(id);
        if (b) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

     /**
      * 添加课程
      *
      * @param course 课程信息
      * @return 添加结果
      */
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Course course) {
        log.info("添加课程：{}", course);
        boolean b = courseService.save(course);
        if (b) {
            return Result.success();
        } else {
            return Result.error("添加失败");
        }
    }

     /**
      * 根据id查询课程
      *
      * @param id 课程id
      * @return 课程信息
      */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询课程：{}", id);
        Course course = courseService.getById(id);
        if (course != null) {
            return Result.success(course);
        } else {
            return Result.error("查询失败");
        }
    }

    public Result getNames(){
        return Result.success(courseService.list().stream().map(Course::getCourseName).toList());
    }


}
