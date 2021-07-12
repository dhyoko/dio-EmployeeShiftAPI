package com.dio.live.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeShiftNotFoundException extends Exception{
    public EmployeeShiftNotFoundException(long id){
        super("Employee Shift not found with " + id);
    }
}
