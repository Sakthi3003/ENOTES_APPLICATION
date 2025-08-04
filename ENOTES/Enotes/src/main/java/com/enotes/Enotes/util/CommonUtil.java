package com.enotes.Enotes.util;

import com.enotes.Enotes.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonUtil {
    public static ResponseEntity<?> createBuildResponse(Object data, HttpStatus status,
    String message) {
        GenericResponse response = GenericResponse.builder()
                .responseStatus(status)
                .status("success")
                .message(message)
                .data(data)
                .build();
        return response.create();
    }
    public static ResponseEntity<?> createErrorResponse(Object data, HttpStatus status, String message){
        GenericResponse response = GenericResponse.builder()
                .responseStatus(status)
                .status(String.valueOf(status.value()))
                .message("Failed")
                .data(data)
                .build();

        return response.create();
    }

    public static ResponseEntity<?> createErrorResponseMessage(Object data, HttpStatus status,
    String message) {
        GenericResponse response = GenericResponse.builder()
                .responseStatus(status)
                .status("Failed")
                .message(message)
                .build();
        return response.create();
    }
}
