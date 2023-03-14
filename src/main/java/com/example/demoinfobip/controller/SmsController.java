package com.example.demoinfobip.controller;

import com.example.demoinfobip.service.SmsService;
import com.infobip.JSON;
import com.infobip.model.SmsDeliveryResult;
import com.infobip.model.SmsReport;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SmsController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public void sendSMS(@RequestBody SmsRequest smsRequest) throws IOException {
        smsService.sendSMS(smsRequest.getSender(),smsRequest.getRecipient(),smsRequest.getMessageText());
    }

    }

