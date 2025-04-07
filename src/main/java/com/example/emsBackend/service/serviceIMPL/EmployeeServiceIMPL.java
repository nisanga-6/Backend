package com.example.emsBackend.service.serviceIMPL;

import com.example.emsBackend.Exception.ResourceNotFoundException;
import com.example.emsBackend.dto.EmployeeDTO;
import com.example.emsBackend.entity.Employee;
import com.example.emsBackend.repository.EmployeeRepo;
import com.example.emsBackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    EmployeeRepo employeeRepo;

    ModelMapper mapper;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

      Employee employee=  mapper.map(employeeDTO, Employee.class);
      Employee emp=employeeRepo.save(employee);
        return mapper.map(emp,EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO findById(Long Id) throws ResourceNotFoundException {
        Employee employee= employeeRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",Id));
        return mapper.map(employee,EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws ResourceNotFoundException {
     Employee employee=   employeeRepo.findById(employeeDTO.getId()).orElseThrow(()->new ResourceNotFoundException("Employee","Id", employeeDTO.getId()));
     employee.setFirstName(employeeDTO.getFirstName());
     employee.setLastName(employeeDTO.getLastName());
     employee.setEmail(employeeDTO.getEmail());
    Employee updatedEmp= employeeRepo.save(employee);
    return mapper.map(updatedEmp,EmployeeDTO.class);

    }

    @Override
    public List<EmployeeDTO> getAll() {
      List<Employee>employeeList=  employeeRepo.findAll();
      return employeeList.stream().map(employee -> mapper.map(employee,EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteById(Long Id) throws ResourceNotFoundException {
     Employee employee=   employeeRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",Id));
     employeeRepo.delete(employee);
     return "User with Id:"+Id +"deleted successfully";

    }

}
