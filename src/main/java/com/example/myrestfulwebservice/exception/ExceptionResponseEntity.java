package com.example.myrestfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class ExceptionResponseEntity {

    private Date date;
    private String message;
    private String details;
}
