package com.student.controller;

import com.student.domain.OperateLog;
import com.student.domain.Result;
import com.student.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 操作日志列表
     *
     * @return 操作日志列表
     */
    @GetMapping
    public Result list() {
        log.info("操作日志列表");
        List<OperateLog> list = reportService.list();
        return Result.success(list);
    }
}
