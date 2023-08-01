package com.smith.social.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DatabaseManipulationException extends ResponseStatusException {

    public DatabaseManipulationException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }
    
}
