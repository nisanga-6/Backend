package com.example.emsBackend.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDTO {

    long id;
    String firstName;
    String lastName;
    String email;
}
