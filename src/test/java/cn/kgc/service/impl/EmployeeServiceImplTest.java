package cn.kgc.service.impl;

import cn.kgc.entity.Employee;
import cn.kgc.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService service;
    @Test
    public void findAllEmp() {
        for (Employee employee : service.findAllEmp()) {
            System.out.println(employee);
        }
    }
}