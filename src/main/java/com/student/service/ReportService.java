package com.student.service;

import com.student.domain.OperateLog;
import com.student.domain.Result;

import java.util.List;

public interface ReportService {
    // 返回所有操作日志
    List<OperateLog> list();
}
