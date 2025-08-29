package com.zayden.notification_service.service;

import com.zayden.notification_service.dto.request.EmailRequest;
import com.zayden.notification_service.dto.request.SendEmailRequest;
import com.zayden.notification_service.dto.request.Sender;
import com.zayden.notification_service.dto.response.EmailResponse;
import com.zayden.notification_service.exception.AppException;
import com.zayden.notification_service.exception.ErrorCode;
import com.zayden.notification_service.repository.httpclient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    @NonFinal
    @Value("${app.api-key}")
    String apiKey;

    public EmailResponse sendEmail(SendEmailRequest request){
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("ZaydenZ")
                        .email("votrantin@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();

        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e){
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}
