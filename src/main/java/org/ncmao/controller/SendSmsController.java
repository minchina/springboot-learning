package org.ncmao.controller;


import org.ncmao.domain.Person;
import org.ncmao.service.SmsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.ncmao.config.RabbitMQConfig.FOO_QUEUE;

@RestController
@RequestMapping("/sms")
public class SendSmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/send/{phoneNumber}", method = RequestMethod.GET)
    @ResponseBody
    public void sendSms(@PathVariable String phoneNumber){
        smsService.validate(phoneNumber);

    }

    @GetMapping("/send/product")
    public void sendProductOrder(){
        Person person = new Person();
        person.setName("message");
        person.setAge(10);
        rabbitTemplate.convertAndSend(FOO_QUEUE, person);
    }

    @RabbitListener(queues = FOO_QUEUE)
    public void mqListener(@Payload Person sms) {
        System.out.println(sms);
    }


}
