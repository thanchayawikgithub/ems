package com.than.ems.services;

import com.than.ems.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto getById(Long employeeId);
}
