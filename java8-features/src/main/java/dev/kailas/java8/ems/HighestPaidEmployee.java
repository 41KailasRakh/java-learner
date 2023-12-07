package dev.kailas.java8.ems;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestPaidEmployee {

    /*
    * Get the details of highest paid employee in the Organization
    *
    * */

    public static void main(String[] args) {

        List<Employee> employeeList = Employee.getEmployeeList();
        Optional<Employee>  optionalEmployee = employeeList.stream()
                .collect(Collectors.maxBy( Comparator.comparing( emp->emp.getSalary()
                )) );
            System.out.println(optionalEmployee.get().getName()+" "+optionalEmployee.get().getSalary());

        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary "+doubleSummaryStatistics.getAverage());
        System.out.println("Total Salary "+doubleSummaryStatistics.getSum());
        System.out.println("Max Salary "+doubleSummaryStatistics.getMax());
    }
}
