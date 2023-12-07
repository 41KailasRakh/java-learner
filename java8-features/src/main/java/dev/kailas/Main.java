package dev.kailas;


import dev.kailas.java8.example.client.CountMaleAndFemale;
import dev.kailas.java8.example.client.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome to JAVA 8 magics! \n");

        // https://blog.devgenius.io/java-8-real-time-coding-interview-questions-and-answers-fce01f3c4080

        // 1. Find out the count of male and female employees present in the organization?
        List<Employee> employeeList = new Employee().getEmployeesList();
        Map<String, Long> countDetailsWithoutJava8 = new CountMaleAndFemale()
                .getCountOfMaleAndFemaleWithoutJava8(employeeList);

        System.out.println("Output " + countDetailsWithoutJava8);

        Map<String, Long> countDetailsWithJava8 = new CountMaleAndFemale()
                .getCountOfMaleAndFemaleWithoutJava8(employeeList);

        System.out.println("Output " + countDetailsWithJava8);

    }

}