package com.test.demo.Mail;

import javax.xml.soap.SAAJResult;

public interface MailSender {

    void send(String to, String subject,String body);
}
