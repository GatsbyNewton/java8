package edu.wzm.action.ch05;

import edu.wzm.action.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/29.
 */
public class Filtering {

    public static void main(String[] args){
        /* filter() */
        List<Dish> vegetarianMenu = menu.stream()
                                        .filter(Dish::isVegetarian)
                                        .collect(toList());
        vegetarianMenu.forEach(System.out::println);
        System.out.println("================== filter =================");

        /* distinct() */
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println("================== distinct =================");

        /* limit() */
        List<Dish> dishes = menu.stream()
                                .filter(d -> d.getCalories() > 300)
                                .limit(3)
                                .collect(toList());
        dishes.forEach(System.out::println);
        System.out.println("================== limit =================");

        /* skip() */
        List<Dish> dishesSkip = menu.stream()
                                    .filter(d -> d.getCalories() > 300)
                                    .skip(2)
                                    .collect(toList());
        dishesSkip.forEach(System.out::println);
        System.out.println("================== skip =================");
    }
}
