package org.ning.bootlearning.service.impl;

import org.ning.bootlearning.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailService implements SendEmail {


    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom("ncmao@cc.com");
            helper.setTo("minchina91@gmail.com");
            helper.setSubject("just test");
            helper.setText("<h1>Dear</h1>", true);

//            FileSystemResource file = new FileSystemResource("/Users/ncmao/dev/test.txt");
//            helper.addAttachment("test111.txt", file);

        }catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(mimeMessage);
    }
}
