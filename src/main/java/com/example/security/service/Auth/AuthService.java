package com.example.security.service.Auth;


import com.example.security.dto.AuthenticationRequestDto;
import com.example.security.dto.JWTAuthenticationResponse;
import com.example.security.dto.SignUpRequetDto;
import com.example.security.entities.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
    User createUser(SignUpRequetDto signUpRequest);
//    Boolean hasCustomerWithPhone(String phone);
   JWTAuthenticationResponse createAuthToken(@RequestBody AuthenticationRequestDto authenticationRequest);
}
