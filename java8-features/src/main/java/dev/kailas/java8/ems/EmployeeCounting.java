package dev.kailas.java8.ems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeCounting {

    public static void main(String[] args) {
        List<Employee> employeeList = Employee.getEmployeeList();
        Map<String,Long> employeeCounting = getEmployeeCountBasedOnGender(employeeList);
        System.out.println(employeeCounting);

        // How many male and female employees are there in the Sale and Marketing
        // Department ?
        Map<String,Long> employees = howManyFaleAndFemaleEmployees(employeeList);
        System.out.println("below is the counting of Sales And Marketing department");
        System.out.println(employees);

        System.out.println("Average Salary Of Male and Female");
        Map<String,Double> avgSalary = getTheAverageSalaryOfMaleAndFemale(employeeList);
        System.out.println(avgSalary);

        // List out the all employees names
        System.out.println("All Employees");
        Map<String,List<Employee>> allEmployees = getAllEmployeeNames(employeeList);
        for(Map.Entry<String,List<Employee>> entry : allEmployees.entrySet()){
            List<Employee> list = entry.getValue();
            System.out.println("Employees In: "+entry.getKey());
            for (Employee employee: list){
                System.out.println(employee.getName());
            }
        }
    }

    private static Map<String,List<Employee>> getAllEmployeeNames(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.toList()
                ));
    }

    private static Map<String, Double> getTheAverageSalaryOfMaleAndFemale(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static Map<String, Long> howManyFaleAndFemaleEmployees(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    }

    private static Map<String,Long> getEmployeeCountBasedOnGender(List<Employee> employeeList) {
        return employeeList.stream()
                .collect( Collectors.groupingBy( employee -> employee.getGender(),
                Collectors.counting() ) );
    }
}
