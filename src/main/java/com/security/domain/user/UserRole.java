package com.security.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN(1),
    USER(2);

    private final int level;

    UserRole(int level) {
        this.level = level;
    }

    public boolean covers(UserRole other) {
        return this.level >= other.level;
    }
}
