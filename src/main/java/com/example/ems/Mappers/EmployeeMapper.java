package com.example.ems.Mappers;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;

public class EmployeeMapper {

    public static Employee toEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());


    }
    public static EmployeeDto toEmployeeDto(Employee employee){
      return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());

    }
}
