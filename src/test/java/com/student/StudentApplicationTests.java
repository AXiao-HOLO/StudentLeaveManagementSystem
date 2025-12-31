package com.student;

import com.student.controller.UserController;
import com.student.domain.Clazz;
import com.student.domain.User;
import com.student.mapper.ClazzMapper;
import com.student.mapper.UserMapper;
import com.student.service.ClazzService;
import com.student.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@SpringBootTest
class StudentApplicationTests {
    @Test
    public void sendSimpleMail() throws Exception {
    }


}
