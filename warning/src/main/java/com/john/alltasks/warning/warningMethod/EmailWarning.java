package com.john.alltasks.warning.warningMethod;

import com.john.alltasks.warning.exceptions.EmailWarnException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 邮件提醒
 */
@Service
@Slf4j
public class EmailWarning {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String userName;

    public void emailWarn(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userName);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("发送告警邮件失败!", e);
            throw new EmailWarnException(500, "发送告警邮件失败!");

        }
    }

}
