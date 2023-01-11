package com.example.demo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FieldsNotFoundException extends StudentException {

    public FieldsNotFoundException(String message){
        super(message);
    }

    public FieldsNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
