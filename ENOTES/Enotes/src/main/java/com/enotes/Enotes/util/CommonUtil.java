package com.enotes.Enotes.util;

import com.enotes.Enotes.dto.GenericResponse;
import com.enotes.Enotes.entity.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonUtil {
    public static ResponseEntity<?> createBuildResponnse(Object data, HttpStatus status,
    String message) {
        GenericResponse response = GenericResponse.builder()
                .responseStatus(status)
                .status("success")
                .message(message)
                .build();
        return response.create();
    }
}
