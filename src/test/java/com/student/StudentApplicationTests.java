package com.student;

import com.student.domain.Clazz;
import com.student.domain.User;
import com.student.mapper.ClazzMapper;
import com.student.service.ClazzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@SpringBootTest
class StudentApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        // 配置发送者邮箱
        message.setFrom("nfwpp79gbl51km@163.com");
        // 配置接受者邮箱
        message.setTo("3082039897@qq.com");
        // 配置邮件主题
        message.setSubject("主题：简单邮件");
        // 配置邮件内容
        message.setText("测试邮件内容");
        // 发送邮件
        mailSender.send(message);
    }

}
