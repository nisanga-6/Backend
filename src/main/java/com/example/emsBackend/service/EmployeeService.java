package com.example.emsBackend.service;

import com.example.emsBackend.Exception.ResourceNotFoundException;
import com.example.emsBackend.dto.EmployeeDTO;
import com.example.emsBackend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO findById(Long Id) throws ResourceNotFoundException;

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws ResourceNotFoundException;

    List<EmployeeDTO> getAll();

    String deleteById(Long Id) throws ResourceNotFoundException;
}
