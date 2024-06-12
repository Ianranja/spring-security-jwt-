package com.example.security.controller;


import com.example.security.configs.JwtAuthenticationFilter;
import com.example.security.constants.AuthConstants;

import com.example.security.dto.AuthenticationRequestDto;
import com.example.security.dto.JWTAuthenticationResponse;
import com.example.security.dto.ResponseDto;
import com.example.security.dto.SignUpRequetDto;

import com.example.security.repositories.UserRepository;
import com.example.security.service.Auth.AuthService;
import com.example.security.service.Jwt.UserService;
import com.example.security.util.JwtUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/sign")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody SignUpRequetDto signUpRequest){
        authService.createUser(signUpRequest);
        String userName= signUpRequest.getFirstName()+" "+signUpRequest.getLastName();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AuthConstants.ACCOUNT_CREATION_CODE,userName+" "+AuthConstants.ACCOUNT_CREATION));
//        return  new ResponseEntity<>("HELLO"+" "+userName+" "+"ACCOUNT CREATION SUCCESS,WELCOME TO OUR E-COMMERCE SERVICE",HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JWTAuthenticationResponse> login(@RequestBody AuthenticationRequestDto authenticationRequest){
        return ResponseEntity.ok(authService.createAuthToken(authenticationRequest));
    }
}
