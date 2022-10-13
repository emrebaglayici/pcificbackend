package com.pcific.pcificbackend.Web.Controllers;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data @Builder
public class CustomerError {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
