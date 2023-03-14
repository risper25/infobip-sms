package com.example.demoinfobip.service;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.ApiKey;
import com.infobip.BaseUrl;
import com.infobip.api.SmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsResponse;
import com.infobip.model.SmsTextualMessage;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsService {
    private static final String BASE_URL = "https://xry24g.api.infobip.com";
    private static final String API_KEY = "App e4812f66d8a1f4efd5db2eca09b85c4b-fc3a5486-94eb-41b3-8678-54b3ef7a6a41";
    private static final String MEDIA_TYPE = "application/json";
    private static final String NOTIFY_URL="https://report.free.beeceptor.com/delivery-reports";
    private ApiClient apiClient = ApiClient.forApiKey(ApiKey.from(API_KEY))
            .withBaseUrl(BaseUrl.from(BASE_URL))
            .build();

    public SmsResponse sendSMS(String sender, String recipient, String messageText) {

        try {
            SmsApi smsApi = new SmsApi(apiClient);
            SmsTextualMessage smsMessage = new SmsTextualMessage()
                    .from(sender)
                    .addDestinationsItem(new SmsDestination().to(recipient))
                    .text(messageText).callbackData("received").notifyContentType(MEDIA_TYPE).notifyUrl(NOTIFY_URL);
            SmsAdvancedTextualRequest smsMessageRequest = new SmsAdvancedTextualRequest()
                    .messages(List.of(smsMessage));

            return smsApi.sendSmsMessage(smsMessageRequest).execute();

        }
        catch (ApiException apiException) {
            // HANDLE THE EXCEPTION
            System.err.println("Failed to send SMS: " + apiException.responseStatusCode());
            System.out.println(apiException.rawResponseBody());
            return null;
        }

    }



}




