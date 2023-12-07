package dev.kailas.java8.inAction.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfCharLambda {

    public static void main(String[] args) {

        // Given a list of words
        List<String> stringList = new ArrayList<>();
        stringList.add("Docker");
        stringList.add("Java");
        stringList.add("JavaScript");
        stringList.add("Rust");

        System.out.println("Word List " + stringList);
        // find out length of the words
        List<Integer> integerList = stringList.stream().sequential()
                .map(word->word.length())
                .collect(Collectors.toList());

        System.out.println("Word length list " + integerList);


    }
}
