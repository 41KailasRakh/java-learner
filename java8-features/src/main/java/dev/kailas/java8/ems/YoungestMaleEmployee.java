package dev.kailas.java8.ems;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class YoungestMaleEmployee {

    /*
    * Get the details of youngest male employee in the
    * product development department?
    *
    * - employeeList to stream
    * - filter product development employees
    * - use maxByfuntion on employee Age
    *
    * */

    public static void main(String[] args) {

        List<Employee> employeeList = Employee.getEmployeeList();
        String department = "Product Development";
        Optional<Employee> youngEmployee = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male") &&
                        employee.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getAge));
        System.out.println(youngEmployee.get());

    }
}
