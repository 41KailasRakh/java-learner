package dev.kailas.java8.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    /*
    * We will see how to
    * - sort in natural order
    * - custom sorting
    * - Comparator class
    * */

    public static void main(String[] args) {

        List<Integer> unsorted = Arrays.asList(3,6,1,2,7,9,8);
        // Natural sorting order
        List<Integer> sortedInt = getDefaultSortingElements(unsorted);
        System.out.println(sortedInt);

        // print element in reverse order
        List<Integer> customSort = getCustomSortingElements(unsorted);
        System.out.println(customSort);
    }

    private static List<Integer> getCustomSortingElements(List<Integer> unsorted) {
        return unsorted.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static List<Integer> getDefaultSortingElements(List<Integer> unsorted) {
        return unsorted.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
