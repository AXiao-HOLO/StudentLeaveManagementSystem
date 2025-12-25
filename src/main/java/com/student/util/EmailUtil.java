package com.student.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailUtil {

    public static void sendSimpleMail(JavaMailSender mailSender, String from, String to, String subject, String text) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        // 配置发送者邮箱
        message.setFrom(from);
        // 配置接受者邮箱
        message.setTo(to);
        // 配置邮件主题
        message.setSubject(subject);
        // 配置邮件内容
        message.setText(text);
        // 发送邮件
        mailSender.send(message);
    }
}
