package com.atnjupt.team.junit;

import org.junit.Test;

import com.atnjupt.team.domain.Employee;
import com.atnjupt.team.service.NameListService;
import com.atnjupt.team.service.TeamException;

public class NameListServiceTest {
    @Test
    public void testNameListService() {
        NameListService n = new NameListService();
        Employee[] employees = n.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testNameListServiceGetEmployee() {
        NameListService n = new NameListService();
        int id = 10;
//		id = 100;
        try {
            Employee employee = n.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            String message = e.getMessage();
            System.out.println(message);
        }


    }
}
