package com.cts.java;
import com.cts.java.Dao.EmployeeRepository;
import com.cts.java.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/*
@SpringBootApplication
public class SpringBootExampleApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
}
*/


@SpringBootApplication
@EnableJpaRepositories("com.cts.java.Dao")
@EntityScan("com.cts.java.Model")
public class SpringBootExampleApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Our DataSource is = " + dataSource);
        Iterable<Employee> employeelist = employeeRepository.findAll();
        for(Employee employeeModel:employeelist){
            System.out.println("Here is a system: " + employeeModel.toString());
        }


    }

}