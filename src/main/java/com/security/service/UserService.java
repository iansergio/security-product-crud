package com.security.service;

import com.security.dto.AuthDTO;
import com.security.dto.RegisterDTO;

public interface UserService {
    AuthDTO login(AuthDTO authDTO);
    RegisterDTO register(RegisterDTO data);
}
