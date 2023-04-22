package com.example.codingTest.service;

import com.example.codingTest.entity.Employee;
import com.example.codingTest.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeService {

    @Autowired
    employeeRepository EmployeeRe;

    public String addEmployee(Employee employee){

        EmployeeRe.save(employee);
        return "Employee Added successfully";
    }

    public Employee deleteEmployee(int id) throws Exception{
        Employee employee=new Employee();
        try{
            employee=EmployeeRe.findById(id).get();
        }
        catch(Exception e){
            throw new Exception("Employee does not exist with this id");
        }
        EmployeeRe.deleteById(id);
        return employee;
    }

    public Employee getEmployee(int id) throws Exception{
        Employee employee=new Employee();
        try{
            employee=EmployeeRe.findById(id).get();
        }
        catch (Exception e){
            throw new Exception("Invalid id");
        }
        return employee;
    }

    public String changeDetails(Employee employee) throws  Exception{
        Employee employee1=new Employee();
        try{
            employee1=EmployeeRe.findById(employee.getId()).get();
        }
        catch (Exception e){
            return "Invalid employee id";
        }
        EmployeeRe.save(employee);
        return "Details updated successfully";
    }

}
