package dev.kailas.java8.ems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageAgeEmployee {

    /*
    * What's the average age of male and female employees
    * */
    public static void main(String[] args) {
        // Employee list
        List<Employee> employeeList = Employee.getEmployeeList();

        Map<String,Double> empAge =employeeList.stream()
                .collect( Collectors.groupingBy( employee -> employee.getGender(), Collectors.averagingInt(emp->emp.getAge())) );
        System.out.println(empAge);
    }
}
