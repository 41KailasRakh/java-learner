package dev.kailas.java8.ems;

import java.util.Comparator;
import java.util.List;

public class MostExperienceEmp {

    public static void main(String[] args) {

        /*
        *
        *  Who is the most working experience in the Organization
        * - emlpoyeeList to stream()
        * - sort employees based on joining Date in reverse order
        * - pick first element from list
         */
        List<Employee> employeeList = Employee.getEmployeeList();
        Employee mostExperiencedEmp = getMostExperiencedEmp(employeeList);
        System.out.println(mostExperiencedEmp.getName()+" most experienced employee");
    }

    private static Employee getMostExperiencedEmp(List<Employee> employeeList) {
        return employeeList.stream()
                /*.sorted((o1, o2) -> {
                    if(o1.getYearOfJoining()> o2.getYearOfJoining())
                        return 1;
                    else if (o1.getYearOfJoining()< o2.getYearOfJoining())
                        return -2;
                    else
                        return 0;
                } )*/
                .sorted(Comparator.comparing(Employee::getYearOfJoining))
                .findFirst().get();

    }
}
