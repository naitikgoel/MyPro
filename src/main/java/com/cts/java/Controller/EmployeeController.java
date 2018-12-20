package com.cts.java.Controller;

import com.cts.java.Dao.EmployeeRepository;
import com.cts.java.Model.Employee;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class EmployeeController {

    //public static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeeController.class);

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

    @RequestMapping("/searchByName")
    public String employeeFindByName(){
        System.out.println("Find by name");
        Employee employee = employeeRepository. findByName("Abhi");
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();
    }

    @RequestMapping(value="/searchbyName", method = RequestMethod.GET)
    @ResponseBody
    public String searchbyName(){
        System.out.println("Find by name pass parameter");
        Employee employee = employeeRepository. findByName("Naitik");
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();

    }

    @RequestMapping(value="/searchbyName1")
    @ResponseBody
    public String employeeDetailsUsingParam2(){
        System.out.println("Find by name pass parameter");
        Employee employee = employeeRepository. findByName("Naitik");
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();

    }

    @RequestMapping("/searchByAge")
    public String employeeFindByAge(){
        System.out.println("Find by Age ");
        Employee employee = employeeRepository.findByAge(27);
        return "Employee Name is "+ employee.getName()+ "======= Age ===="+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();
    }

    @RequestMapping("/searchByExperience")
    public String employeeFindByExperience(){
        System.out.println("Find by Age ");
        Employee employee = employeeRepository.findByExperience(8);
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();
    }

    @RequestMapping("/searchByNameAndAge")
    public String employeeFindByNameAndAge(){
        System.out.println("Find by Name and Age ");
        List<Employee> employeeList = employeeRepository.findByNameAndAge("Rajesh",30);
        StringBuffer strBuf = new StringBuffer();
        for(Employee employee : employeeList) {
           strBuf = strBuf.append("Employee Name is " + employee.getName() + "Age" + employee.getAge() + "Email" + employee.getEmail() + "Experience" + employee.getExperience() + "address" + employee.getAddress());
        }
        return strBuf.toString();
    }

    @RequestMapping(value = "/searchByNameAndAgeJson", produces = { "application/json", "application/xml" })
    @ResponseBody
    public Object employeeFindByNameAndAgeJson() {
        System.out.println("Find by Name and Age json object");
        List<Employee> employeeList = employeeRepository.findByNameAndAge("Rajesh",30);
        StringBuilder strBuf = new StringBuilder();
        for(Employee employee : employeeList) {
            strBuf = strBuf.append("Employee Name is " + employee.getName() + "Age" + employee.getAge() + "Email" + employee.getEmail() + "Experience" + employee.getExperience() + "address" + employee.getAddress());
        }

        Gson gson = new Gson();
        // convert your list to json
        String jsonCartList = gson.toJson(employeeList);
        // print your generated json
        System.out.println("jsonCartList: " + jsonCartList);

        return jsonCartList;

    }



    @RequestMapping(value="/passparameter/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String employeeDetailsUsingParam( @PathVariable("name") String name){
        //http://localhost:8080/passparameter/Anu
        System.out.println("Find by name pass parameter");
        Employee employee = employeeRepository. findByName(name);
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();

    }

    @RequestMapping(value="/passparameter1/{name}/age/{age}", method = RequestMethod.GET)
    @ResponseBody
    public String employeeDetailsUsingParam1( @PathVariable("name") String name, @PathVariable("age") Integer age){
        //http://localhost:8080/passparameter1/Naitik/age/28
        System.out.println("Find by Name and Age with Param");
        List<Employee> employeeList = employeeRepository.findByNameAndAge(name, age);
        StringBuffer strBuf = new StringBuffer();
        for(Employee employee : employeeList) {
            strBuf = strBuf.append("Employee Name is " + employee.getName() + "Age" + employee.getAge() + "Email" + employee.getEmail() + "Experience" + employee.getExperience() + "address" + employee.getAddress());
        }
        return strBuf.toString();
    }

    @RequestMapping(value="/passparameter2", method = RequestMethod.GET)
    @ResponseBody
    public String employeeDetailsUsingParam2( @RequestParam("name") String name){
        //http://localhost:8080/passparameter2?name=Anu
        //************************************
        System.out.println("Find by name pass parameter");
        Employee employee = employeeRepository. findByName(name);
        return "Employee Name is "+ employee.getName()+ "Age"+employee.getAge()+"Email"+employee.getEmail()+"Experience"+employee.getExperience()+"address"+employee.getAddress();

    }

}
