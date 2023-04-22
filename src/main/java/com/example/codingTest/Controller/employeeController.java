package com.example.codingTest.Controller;

import com.example.codingTest.entity.Employee;
import com.example.codingTest.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class employeeController {

    @Autowired
    employeeService EmployeeService;


    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        try{

        return EmployeeService.addEmployee(employee);

        }
        catch(Exception e){
        return "Sorry there is some error";
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam("id") int id){
        try{
            return new ResponseEntity<>(EmployeeService.deleteEmployee(id), HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> getEmployee(@RequestParam("id") int id){
        try{
            return new ResponseEntity<>(EmployeeService.getEmployee(id),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/changeDetails")
    public String changeDetails(@RequestBody Employee employeee){
        try{
            return EmployeeService.changeDetails(employeee);
        }
        catch (Exception e ){
            return "Employee id invalid";
        }
    }

}
