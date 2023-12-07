package dev.kailas.java8.inAction.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample1 {

    public static void main(String[] args) {
        // You have list of words
        List<String> words = new ArrayList<>();
        words.add("Docker");
        words.add("Java");
        words.add("JavaScript");

        // Now my requirement is cretae a list of unique character out of words
        // that's great, we can covert list of words to list of character using map funtion
        // then we can apply distinct function to get the unique character stream.
        // Let's try it.

        // solution 1 won't work, in this approch map function produces Stream<String[]>
        // and what we want is Stream<String>
       /* List<String[]> uniqueChars = words.stream()
                .map(word->word.split(""))
                .distinct()
                .collect(Collectors.toList());
        */
        // solution 2 won't work
     /*  List<String[]> uniqueChars = words.stream()
                .map(word->word.split(""))
               .map(array -> Arrays.stream(array))
                .distinct()
                .collect(Collectors.toList());*/

        // Solution 3 is use flatMap !

        List<String> uniqueChars = words.stream()
                .map(word->word.split(""))
                .flatMap(array -> Arrays.stream(array))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueChars);
    }
}
