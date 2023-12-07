package dev.kailas.java8.ems;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeByJoinedDate {


    /*
    * Get the names of all employee who joined after <year>
    * */
    public static void main(String[] args) {

        List<Employee> employeeList = Employee.getEmployeeList();
        int year = 2015;
        List<Employee> employees = getAllEmployeeByJoinedDate(employeeList, year);
        System.out.println(employees);
    }

    private static List<Employee> getAllEmployeeByJoinedDate(List<Employee> employeeList, int year) {
        return employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > year)
                .collect(Collectors.toList());
    }
}
