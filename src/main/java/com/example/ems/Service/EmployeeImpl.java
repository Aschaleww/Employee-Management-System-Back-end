package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeImpl {
    EmployeeDto create(EmployeeDto employeeDto);
   EmployeeDto getEmployeById(Long id);
   List<EmployeeDto> getAll();
   EmployeeDto update(Long id, EmployeeDto employeeDto);
   void deleteById(Long id);
}
