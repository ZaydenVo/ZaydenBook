package com.zayden.identity.mapper;

import com.zayden.identity.dto.request.ProfileCreationRequest;
import com.zayden.identity.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
