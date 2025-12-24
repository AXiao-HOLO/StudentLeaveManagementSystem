package com.student.mapper;

import com.student.domain.Clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author AXiao
* @description 针对表【clazz(班级表)】的数据库操作Mapper
* @createDate 2025-12-24 09:11:19
* @Entity com.student.domain.Clazz
*/
@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {

}




