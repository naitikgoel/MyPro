package com.cts.java.Controller;

import com.cts.java.Dao.EmployeeRepository;
import com.cts.java.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employeedetail")
    public String employeeDetails(){
        System.out.println("Our DataSource is = " + dataSource);
        Iterable<Employee> employeelist = employeeRepository.findAll();
        for(Employee employeeModel:employeelist){
            System.out.println("Here is a system: " + employeeModel.toString());
        }
        return "naitik find All ";
    }

    @RequestMapping("/oneemployee")
    public String employeeDetailById(){
        System.out.println("Our DataSource is = " + dataSource);
        Optional<Employee> employee = employeeRepository.findById((long) 10);
        System.out.println("Here is a system: " + employee.toString());
        return "naitik find by Id";
    }
    @RequestMapping("/employeebyname")
    public String employeeFindById(){
        System.out.println("Our DataSource is = " + dataSource);
        System.out.println("Row count in Employee table" + employeeRepository.count());
        Employee employee = employeeRepository.findById((long) 10).get();
        employeeRepository.delete(employee);
        return "Employee name"+employee.getName()+ "is deleted";
    }

    @RequestMapping("/deleteall")
    public String employeeDeleted(){
        System.out.println("Our DataSource is = " + dataSource);
        employeeRepository.deleteAll();
        return "All employee deleted";
    }

}