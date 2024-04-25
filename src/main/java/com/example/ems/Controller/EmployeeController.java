package com.example.ems.Controller;

import com.example.ems.Dto.EmployeeDto;
import com.example.ems.Entity.Employee;
import com.example.ems.Repository.EmployeeRepository;
import com.example.ems.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto emp = employeeService.create(employeeDto);
      return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }


      @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable  Long id){
     EmployeeDto employeeDto = employeeService.getEmployeById(id);
     return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        List<EmployeeDto> e = employeeService.getAll();
       return ResponseEntity.ok(e);
    }
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> UpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto emp = employeeService.update(id, employeeDto);

        return ResponseEntity.ok(emp);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.deleteById(id);

        return ResponseEntity.ok("Successfully deleted with id " +id);
    }
}
