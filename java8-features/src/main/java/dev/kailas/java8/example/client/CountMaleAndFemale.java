package dev.kailas.java8.example.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountMaleAndFemale {

    // Find out the count of male and female  present in the organization?

    public Map<String, Long> getCountOfMaleAndFemaleWithoutJava8(List<Employee> employees){
        long male = 0 ;
        long female = 0 ;
        for(Employee employee : employees){
           if( employee.getGender().equalsIgnoreCase("Female")){
               female ++;
           }else{
               male++;
           }
        }
        Map<String,Long> countDetails = new HashMap<>();
        countDetails.put("Male count is : ", male);
        countDetails.put("Female count is : ", female);

        return countDetails;
    }

    public Map<String, Long> getCountOfMaleAndFemaleWitJava8(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }
}
