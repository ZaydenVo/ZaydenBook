package com.zayden.identity.mapper;

import org.mapstruct.Mapper;

import com.zayden.identity.dto.request.PermissionRequest;
import com.zayden.identity.dto.response.PermissionResponse;
import com.zayden.identity.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
