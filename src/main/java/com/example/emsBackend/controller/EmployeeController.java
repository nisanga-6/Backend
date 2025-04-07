package com.example.emsBackend.controller;

import com.example.emsBackend.Exception.ResourceNotFoundException;
import com.example.emsBackend.dto.EmployeeDTO;
import com.example.emsBackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService service;

    @PostMapping("/create")
    ResponseEntity<EmployeeDTO>createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(service.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{Id}")
    ResponseEntity<EmployeeDTO>getEmployeeById(@PathVariable("Id") Long Id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.findById(Id),HttpStatus.FOUND);
    }

    @PutMapping("/update/{Id}")
    ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("Id") Long Id,@RequestBody EmployeeDTO employeeDTO ) throws ResourceNotFoundException {
        employeeDTO.setId(Id);
        return new ResponseEntity<>(service.updateEmployee(employeeDTO),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<EmployeeDTO>>getAllEmployees(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById")
    ResponseEntity<String>deleteEmployeeById(@PathVariable("Id") Long Id) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.deleteById(Id),HttpStatus.OK);
    }
}
