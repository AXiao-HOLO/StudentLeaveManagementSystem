package com.student.controller;

import com.student.domain.Clazz;
import com.student.domain.Result;
import com.student.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author AXiao
 * @description 班级表接口
 * @createDate 2025-12-24 09:05:29
 */
@Slf4j
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

      /**
       * 班级列表
       * @return 班级列表
       */
    @GetMapping
    public Result list() {
        log.info("班级列表");
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }

     /**
      * 删除班级
      * @param id 班级id
      * @return 删除结果
      */
    @RequestMapping
    public Result delete(Integer id) {
        log.info("删除班级：{}", id);
        boolean b = clazzService.removeById(id);
        if (b) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

     /**
      * 新增班级
      * @param clazz 班级信息
      * @return 新增结果
      */
    @PostMapping
    public Result save(Clazz clazz) {
        log.info("新增班级：{}", clazz);
        boolean b = clazzService.saveOrUpdate(clazz);
        if (b) {
            return Result.success();
        } else {
            return Result.error("新增失败");
        }
    }

     /**
      * 更新班级
      * @param clazz 班级信息
      * @return 更新结果
      */
    @PutMapping
    public Result update(Clazz clazz) {
        log.info("更新班级：{}", clazz);
        boolean b = clazzService.saveOrUpdate(clazz);
        if (b) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }
    }

     /**
      * 根据id查询班级
      * @param id 班级id
      * @return 班级信息
      */
    @GetMapping("/{id}")
    public Result getById(Integer id) {
        log.info("根据id查询班级：{}", id);
        Clazz clazz = clazzService.getById(id);
        if (clazz != null) {
            return Result.success(clazz);
        } else {
            return Result.error("查询失败");
        }
    }


}
