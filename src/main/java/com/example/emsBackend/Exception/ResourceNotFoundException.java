package com.example.emsBackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    String resourceName;
    String fieldName;
    Long fieldValue;
    public ResourceNotFoundException(String resourceName,String fieldName,Long fieldValue ){
        super(String.format("%s is not found with %s: '%s'",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
