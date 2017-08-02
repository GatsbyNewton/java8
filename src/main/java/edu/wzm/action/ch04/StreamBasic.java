package edu.wzm.action.ch04;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gatsbynewton on 2017/7/27.
 */
public class StreamBasic {

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes){
            if (dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        for (Dish dish : lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }

        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
//                .map(dish -> dish.getName())
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args){
        /* in Java7 */
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(d -> System.out.println(d));

        /* in Java8 */
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }
}
