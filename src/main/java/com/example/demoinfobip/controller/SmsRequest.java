package com.example.demoinfobip.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SmsRequest {
    private  String sender;
    private String recipient;
    private String messageText;
}
