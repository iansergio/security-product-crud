package com.security.dto;

public record AuthDTO (
        String username,
        String password,
        String token
){
}
