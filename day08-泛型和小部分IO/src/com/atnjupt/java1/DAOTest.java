package com.atnjupt.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author Wizarder
 * @create 2021-03-03 17:11
 */
public class DAOTest {
    @Test
    public void test() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
        List<Customer> forList = customerDAO.getForList(10);

        StudentDAO studentDAO = new StudentDAO();
        Student index = studentDAO.getIndex(10);
    }

}
