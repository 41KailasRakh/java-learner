package dev.kailas.java8.geeks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OcurrenceOfEachChar {



    public static void main(String[] args) {

        /*
         * Write a Java program which prints number of occurrence of
         * each character
         * */
        String inputString = "geeksforgeeks";
        printOccurrenceOfCharWithLambda(inputString);
        printOccurrenceOfChar(inputString);


        /*
        * Move all zeroes to end of array
        *
        * Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
          Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};

            Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
            Output : arr[] = {1, 2, 3, 6, 0, 0, 0};

        * */
       // int[] inputArray = {2,0,0,4,5,6,7,0,9};
        int[] inputArray = {0,0,2,0,0};
        int[] resultArray = pushZerosToEndOfArray(inputArray);

    }

    private static int[] pushZerosToEndOfArray(int[] inputArray) {
        System.out.println("Input "+Arrays.toString(inputArray));
        int count =0 ; // To count the non-zero elements
        // Traverse the array. If the element encountered, then replace
        // the element at index 'count' with this element.
        for(int i=0; i<inputArray.length; i++){
            if(inputArray[i] != 0){
                inputArray[count]=inputArray[i];
                count ++;

            }
        }
        while (count<inputArray.length){
            inputArray[count++]=0;
        }

        System.out.println("Output "+Arrays.toString(inputArray));
        return inputArray;
    }

    private static void printOccurrenceOfChar(String inputString) {
        ArrayList<Character> arrayList = new ArrayList();
        for(int i=0; i<inputString.length(); i++){
            arrayList.add(inputString.charAt(i));
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<inputString.length(); i++){
            hm.putIfAbsent(arrayList.get(i), frequency(arrayList,arrayList.get(i)));
        }
        for(Map.Entry<Character,Integer> entry : hm.entrySet()){
            System.out.println(entry.getKey()+" Occurred "+ entry.getValue()+" times");
        }
    }

    public static int frequency(Collection<?> c,Object o){
        int result =0;
            if(o==null){
                for(Object e : c ){
                    if(e==null)
                        return result;
                }
            }else {
                for(Object e : c){
                    if(e.equals(o))
                        result++;
                }
            }
        return result;
    }
    private static void printOccurrenceOfCharWithLambda(String inputString) {
        System.out.println(Stream.of(inputString)
                .map(input->input.split(""))
                .flatMap(flattenString-> Arrays.stream(flattenString)).sequential()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

}
