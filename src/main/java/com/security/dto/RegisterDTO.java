package com.security.dto;

import com.security.domain.user.UserRole;

public record RegisterDTO(
        String username,
        String password,
        UserRole role
) {
}
