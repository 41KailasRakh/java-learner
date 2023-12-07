package dev.kailas.java8.inAction.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SquareEachNumberLambda {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
            numbers.add(2);
            numbers.add(3);
            numbers.add(5);
            numbers.add(7);
        System.out.println(numbers);
        List<Integer> sqaures = numbers.stream()
                .map(number -> number*number)
                .collect(Collectors.toList());

        System.out.println(sqaures);
    }
}
