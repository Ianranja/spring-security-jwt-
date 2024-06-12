package com.example.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;

//    public ResponseDto(String accountCreation, String accountCreationCode) {
//    }
}
