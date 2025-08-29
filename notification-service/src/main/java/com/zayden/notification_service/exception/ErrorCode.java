package com.zayden.notification_service.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception.", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHENTICATED(1006, "Unauthenticated!", HttpStatus.UNAUTHORIZED),
    CANNOT_SEND_EMAIL(1010, "Cannot send email!", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
