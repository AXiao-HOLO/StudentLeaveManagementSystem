package com.student.controller;

import com.student.anno.LogOperation;
import com.student.domain.LeaveApplication;
import com.student.domain.PageResult;
import com.student.domain.Result;
import com.student.domain.queryParam.LeaveQueryParam;
import com.student.service.LeaveApplicationService;
import com.student.service.StudentService;
import com.student.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/leave")
@Slf4j
public class LeaveController {
    @Autowired
    private LeaveApplicationService leaveApplicationService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private StudentService studentService;

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
    @LogOperation
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
    @LogOperation
    @PostMapping
    public Result save(@RequestBody LeaveApplication leaveApplication) {
        log.info("保存请假申请：{}", leaveApplication);
        // 如果请假申请的审批状态发生改变，发送邮件通知学生
        if (!Objects.equals(leaveApplication.getStatus(), leaveApplicationService.getById(leaveApplication.getId()).getStatus())) {
            try {
                String status = leaveApplication.getStatus() == 0 ? "待批阅" : leaveApplication.getStatus() == 1 ? "已通过" : "已驳回";
                EmailUtil.sendSimpleMail(mailSender, "nfwpp79gbl51km@163.com", studentService.getById(leaveApplication.getStudentId()).getEmail(),
                        "请假申请状态更新", "您于" + leaveApplicationService.getById(leaveApplication.getId()).getCreateTime() + "提交的请假申请状态已更新为：" + status);
            } catch (Exception e) {
                log.error("发送邮件失败", e);
            }
        }
        leaveApplicationService.saveOrUpdate(leaveApplication);
        return Result.success();
    }

     /**
     * 根据id查询请假申请
     * @param id 请假申请id
     * @return 请假申请
     */
    @LogOperation
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询请假申请：{}", id);
        LeaveApplication leaveApplication = leaveApplicationService.getById(id);
        return Result.success(leaveApplication);
    }
}
