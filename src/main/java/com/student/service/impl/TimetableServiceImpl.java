package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Timetable;
import com.student.service.TimetableService;
import com.student.mapper.TimetableMapper;
import org.springframework.stereotype.Service;

/**
* @author AXiao
* @description 针对表【timetable(课表主表)】的数据库操作Service实现
* @createDate 2025-12-24 09:05:53
*/
@Service
public class TimetableServiceImpl extends ServiceImpl<TimetableMapper, Timetable>
    implements TimetableService{

}




