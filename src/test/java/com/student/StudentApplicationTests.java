package com.student;

import com.student.domain.Clazz;
import com.student.mapper.ClazzMapper;
import com.student.service.ClazzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentApplicationTests {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzService clazzService;
    @Test
    void contextLoads() {
        // 测试班级列表
        List<Clazz> list = clazzService.list();
        System.out.println(list);
    }

}
