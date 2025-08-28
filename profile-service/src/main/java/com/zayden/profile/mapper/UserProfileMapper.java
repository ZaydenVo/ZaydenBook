package com.zayden.profile.mapper;

import org.mapstruct.Mapper;

import com.zayden.profile.dto.request.ProfileCreationRequest;
import com.zayden.profile.dto.response.UserProfileResponse;
import com.zayden.profile.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
