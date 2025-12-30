package com.student.mapper;

import com.student.domain.Timetable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
* @author AXiao
* @description 针对表【timetable(课表主表)】的数据库操作Mapper
* @createDate 2025-12-24 09:05:53
* @Entity com.student.domain.Timetable
*/
@Mapper
public interface TimetableMapper extends BaseMapper<Timetable> {

    List<Timetable> getInfoByClassId(Integer classId);
}




