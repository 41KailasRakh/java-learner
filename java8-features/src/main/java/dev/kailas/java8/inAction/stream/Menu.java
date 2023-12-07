package dev.kailas.java8.inAction.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {

    public static void main(String[] args) {

        Map<String,Integer> menuWithCal = getMenuWithCal();
        System.out.println(menuWithCal);

        Map<String,Integer> highCalDishes = getHighCaloriesDishes();
        System.out.println("Total High Calories available: "+highCalDishes);

        List<String> threeHighCalDishes = getHighCalDishes();
        System.out.println("High Calorie Dishes with limit "+threeHighCalDishes);

        List<String> skipSomeHighCalDishes = skipSomeHighCalDishes();
        System.out.println("After Skip "+skipSomeHighCalDishes);


        List<Dish> limitTheDish = getLimitMeatDish();


    }

    private static List<Dish> getLimitMeatDish() {
        return getMenu().stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> getHighCaloriesDishes() {
        return getMenu().stream()
                .filter(dish -> dish.getCalaries()>400)
                .collect(Collectors.toMap(Dish::getName,Dish::getCalaries));
    }

    private static Map<String, Integer> getMenuWithCal() {

        List<Dish> dishes = getMenu();

        /*Map<String, Integer> menuWithCal = new HashMap<>();
        for( Dish d : dishes){
            menuWithCal.put(d.getName(),d.getCalaries());
        }*/

        Map<String, Integer>  menuWithCal =dishes.stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalaries));
        System.out.println("Grouping by dish type "+dishes.stream()
                .collect(Collectors.groupingBy(Dish::getType)));
         return menuWithCal;
    }

    private static List<String> getHighCalDishes() {

        List<Dish> menu = getMenu();
        return menu.stream()
                .filter(d->d.getCalaries()>400)
                .map(d->d.getName())
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<String> skipSomeHighCalDishes(){
        List<Dish> menu = getMenu();
        return menu.stream()
                .filter(dish -> dish.getCalaries() > 400)
                .skip(2)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    private static List<Dish> getMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }
}
