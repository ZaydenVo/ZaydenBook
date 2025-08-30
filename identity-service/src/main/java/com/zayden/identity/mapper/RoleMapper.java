package com.zayden.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zayden.identity.dto.request.RoleRequest;
import com.zayden.identity.dto.response.RoleResponse;
import com.zayden.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
