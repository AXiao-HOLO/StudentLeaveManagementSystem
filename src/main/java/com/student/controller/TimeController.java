package com.student.controller;

import com.student.anno.LogOperation;
import com.student.domain.Result;
import com.student.domain.Timetable;
import com.student.service.TimetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/timetable")
public class TimeController {
    @Autowired
    private TimetableService timetableService;
    /**
     * 获取所有课程表
     * @return
     */
    @GetMapping("/class/{classId}")
    public Result list(@PathVariable Integer classId) {
        log.info("根据班级ID查询课表信息：{}", classId);
        return Result.success(timetableService.getInfoByClassId(classId));
    }

     /**
     * 添加课程表
     * @param timetable
     * @return
     */
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Timetable timetable) {
        return Result.success(timetableService.saveOrUpdate(timetable));
    }

     /**
     * 删除课程表
     * @param id
     * @return
     */
    @LogOperation
    @DeleteMapping
    public Result deleteById(Integer id) {
        return Result.success(timetableService.removeById(id));
    }

    // 更新课程表
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Timetable timetable) {
        return Result.success(timetableService.saveOrUpdate(timetable));
    }

    // 查询课程表详情
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(timetableService.getById(id));
    }

}
