package com.than.ems.services.impl;

import com.than.ems.dto.EmployeeDto;
import com.than.ems.entities.Employee;
import com.than.ems.exceptions.ResourceNotFoundException;
import com.than.ems.mappers.EmployeeMapper;
import com.than.ems.repositories.EmployeeRepository;
import com.than.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
