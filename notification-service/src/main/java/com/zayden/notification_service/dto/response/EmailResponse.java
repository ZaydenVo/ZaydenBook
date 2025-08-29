package com.zayden.notification_service.dto.response;

import com.zayden.notification_service.dto.request.Recipient;
import com.zayden.notification_service.dto.request.Sender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailResponse {
    String messageId;
}
