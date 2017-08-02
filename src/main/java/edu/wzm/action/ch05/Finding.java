package edu.wzm.action.ch05;

import edu.wzm.action.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/29.
 */
public class Finding {

    public static void main(String[] args){
        /* anyMatch */
        boolean anyMatch = menu.stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println(anyMatch);

        /* allMatch */
        boolean allMatch = menu.stream()
                .allMatch((Dish d) -> d.getCalories() >= 1000);
        System.out.println(allMatch);

        /* findAny */
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish.orElseGet(() -> new Dish("test", false, -1, Dish.Type.OTHER)));

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        /* findFirst */
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> fisrtNumber = number.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();

        System.out.println(fisrtNumber.orElseGet(() -> -1));
    }
}
