package com.security.service;

import com.security.domain.user.User;
import com.security.dto.AuthDTO;
import com.security.dto.RegisterDTO;
import com.security.infrastructure.security.TokenService;
import com.security.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

     private final UserRepository userRepository;
     private final AuthenticationManager authenticationManager;
     private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, TokenService tokenService) {
         this.userRepository = userRepository;
         this.authenticationManager = authenticationManager;
         this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

     public AuthDTO login(AuthDTO authDTO) {
         // Cria o objeto de autenticação
         var usernamePassword = new UsernamePasswordAuthenticationToken(
                 authDTO.username(),
                 authDTO.password()
         );
         // Autentica o usuário
         var auth = authenticationManager.authenticate(usernamePassword);

         // Gera o token Jwt
          String token = tokenService.generateToken((User) auth.getPrincipal());

         return new AuthDTO(authDTO.username(), authDTO.password(), token);
     }

     public RegisterDTO register(RegisterDTO data) {
        if (userRepository.existsByUsername(data.username())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());
        User savedUser = userRepository.save(newUser);

        return new RegisterDTO(savedUser.getUsername(), encryptedPassword, savedUser.getRole());
     }
}
