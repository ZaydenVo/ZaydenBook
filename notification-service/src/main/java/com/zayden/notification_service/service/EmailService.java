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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    String apiKey = "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";

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
