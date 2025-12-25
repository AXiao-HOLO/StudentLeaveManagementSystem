package com.student.controller;

import com.student.domain.LeaveApplication;
import com.student.domain.PageResult;
import com.student.domain.Result;
import com.student.domain.queryParam.LeaveQueryParam;
import com.student.service.LeaveApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@Slf4j
public class LeaveController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;

    /**
     * 分页查询请假申请
     * @param param 查询参数
     * @return 请假申请分页结果
     */
    @GetMapping
    public Result page(LeaveQueryParam param) {
        log.info("分页查询请假申请：{}", param);
        PageResult pageResult = leaveApplicationService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 删除请假申请
     * @param id 请假申请id
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除请假申请：{}", id);
        leaveApplicationService.removeById(id);
        return Result.success();
    }

    /**
     * 保存请假申请
     * @param leaveApplication 请假申请
     * @return 保存结果
     */
    @PostMapping
    public Result save(@RequestBody LeaveApplication leaveApplication) {
        log.info("保存请假申请：{}", leaveApplication);
        leaveApplicationService.saveOrUpdate(leaveApplication);
        return Result.success();
    }

     /**
     * 根据id查询请假申请
     * @param id 请假申请id
     * @return 请假申请
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询请假申请：{}", id);
        LeaveApplication leaveApplication = leaveApplicationService.getById(id);
        return Result.success(leaveApplication);
    }
}
