package com.zayden.identity_service.repository.profileClient;

import com.zayden.identity_service.dto.request.ProfileCreationRequest;
import com.zayden.identity_service.dto.response.ApiResponse;
import com.zayden.identity_service.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "profile-service", url = "${app.services.profile}")
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    void createProfile(@RequestBody ProfileCreationRequest request);
}
