package dev.kailas.java8.inAction.stream.allInpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindTransactionByYear {

    // 1. Find all transactions in the year 2011 and sort them by value (small to High )

    public static List<Transactions> getTransactionDetails(){

        List<Transactions> transactions = null;

        // Create Traders
        Trader kailas = new Trader("Kailas","Beed");
        Trader surya = new Trader("Suresh","Islampur");
        Trader vishal = new Trader("Vishal","Ichalkaranji");
        Trader raju = new Trader("Raju","Ichalkaranji");

        transactions = Arrays.asList(
            new Transactions(kailas,2020,90000),
            new Transactions(surya,2019,120000),
            new Transactions(vishal,2015,200000),
            new Transactions(raju,2016,190000),
            new Transactions(kailas,2015,90000),
                new Transactions(surya,2020,120000),
                new Transactions(vishal,2015,200000),
                new Transactions(raju,2015,190000)
        );
        return transactions;
    }

    public static List<Transactions> getTransactionByYear(int year){

        return  getTransactionDetails().stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(Comparator.comparing(Transactions::getValue))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // find all transaction for year 2015
        System.out.println(getTransactionByYear(2015));

        // What are all the unique cities where the traders work?
        System.out.println(getTradesFromUniqueCities());

        //  Find all traders from Ichalkarnji and sort them by name
        System.out.println(getTraderFromSameCity("Ichalkaranji"));

        // What’s the highest value of all the transaction
        System.out.println("Highest value of transaction "+getHighestTransaction());
    }

    private static Integer getHighestTransaction() {
        return getTransactionDetails().stream()
                .reduce( (t1,t2)-> t1.getValue() < t2.getValue() ? t1 : t2)
                .get().getValue();
    }

    private static List<Trader> getTraderFromSameCity(String city) {
        return getTransactionDetails().stream()
                .filter(transactions -> transactions.getTrader().getCity().equals(city))
                .map(transactions -> transactions.getTrader())
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> getTradesFromUniqueCities() {
        return getTransactionDetails().stream()
                .map(transactions -> transactions.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }
}
