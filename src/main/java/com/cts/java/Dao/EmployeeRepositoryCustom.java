package com.cts.java.Dao;

import com.cts.java.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepositoryCustom{
    //@Query("SELECT p FROM Person p WHERE LOWER(p.name) = LOWER(:name)")
    Employee findByName(@Param("name")String name);
    Employee findByExperience(@Param("experience")Integer experience);
    Employee findByAge(@Param("age")Integer age);
}
