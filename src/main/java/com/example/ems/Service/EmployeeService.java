package com.example.ems.Service;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Exception.NotFounfException;
import com.example.ems.Mappers.EmployeeMapper;
import com.example.ems.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeImpl{
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee save= employeeRepository.save(employee);
        EmployeeDto emp = EmployeeMapper.toEmployeeDto(save);

        return emp;
    }

    @Override
    public EmployeeDto getEmployeById(Long id) {
        Employee emp = employeeRepository
                .findById(id)
                .orElseThrow(()-> new NotFounfException("not found"));
        return EmployeeMapper.toEmployeeDto(emp);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> emp = employeeRepository.findAll();
        return emp.stream().map((employee -> EmployeeMapper.toEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        Employee  emp = employeeRepository
                .findById(id)
                .orElseThrow(()-> new NotFounfException("Employee with this id is not found"));

        emp.setFirstName(employeeDto.getFirstName());
        emp.setLastName(employeeDto.getLastName());
        emp.setEmail(employeeDto.getEmail());

        Employee emp1 = employeeRepository.save(emp);

        return  EmployeeMapper.toEmployeeDto(emp1);
    }
    @Override
    public void deleteById(Long id){
        Employee emp = employeeRepository
                .findById(id)
                .orElseThrow(()-> new NotFounfException("This id is not found"));
        employeeRepository.deleteById(id);
    }
}
