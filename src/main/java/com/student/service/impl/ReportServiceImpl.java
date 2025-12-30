package com.student.service.impl;

import com.student.domain.OperateLog;
import com.student.domain.Result;
import com.student.mapper.ReportMapper;
import com.student.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<OperateLog> list() {
        return reportMapper.list();
    }
}
