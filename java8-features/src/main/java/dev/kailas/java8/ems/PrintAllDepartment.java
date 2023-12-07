package dev.kailas.java8.ems;

import java.util.List;
import java.util.stream.Collectors;

public class PrintAllDepartment {

    public static void main(String[] args) {

        // Employee list
        List<Employee> employeeList = Employee.getEmployeeList();
        // List of String to store the result to store all departments
        List<String> departments = printAllDepartments(employeeList);
        System.out.println(departments);
    }

    private static List<String> printAllDepartments(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> employee.getDepartment())
                .collect(Collectors.toList());
    }
}
