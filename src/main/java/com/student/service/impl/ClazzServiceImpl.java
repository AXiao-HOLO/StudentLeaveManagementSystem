package com.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.domain.Clazz;
import com.student.service.ClazzService;
import com.student.mapper.ClazzMapper;
import org.springframework.stereotype.Service;

/**
* @author AXiao
* @description 针对表【clazz(班级表)】的数据库操作Service实现
* @createDate 2025-12-24 09:11:19
*/
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz>
    implements ClazzService{

}




