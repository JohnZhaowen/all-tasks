package com.john.alltasks.warning.warningMethod.processor;

import com.john.alltasks.warning.enums.WarningMethodEnum;
import com.john.alltasks.warning.exceptions.EmailWarnException;
import com.john.alltasks.warning.models.User;
import com.john.alltasks.warning.models.Warning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/15
 * ticket:
 * description: 邮件提醒
 */
@Service
@Slf4j
public class EmailWarnProcessor implements WarnProcessor {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Override
    public String getCode() {
        return WarningMethodEnum.EMAIL.name();
    }

    @Override
    public void process(Warning warning) {
        List<User> handers = warning.getHanders();
        if(!CollectionUtils.isEmpty(handers)){
            handers.parallelStream().forEach(h -> {
                SimpleMailMessage message = getEmailMessage(warning, h);
                sendEmail(message);
            });
        }
    }

    private void sendEmail(SimpleMailMessage message) {
        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("发送告警邮件失败!", e);
            throw new EmailWarnException(500, "发送告警邮件失败!");
        }
    }

    private SimpleMailMessage getEmailMessage(Warning warning, User h) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userName);
        message.setTo(h.getEmail());
        message.setSubject("告警提醒");
        message.setText(warning.getWarnContent());
        return message;
    }

}
