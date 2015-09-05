package org.ning.bootlearning;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.ning.bootlearning.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
public class SendMailTest {
    @Autowired
    private MailService mailService;


    @Test
    public void shouldSendEmail() {
        mailService.send();
    }
}
