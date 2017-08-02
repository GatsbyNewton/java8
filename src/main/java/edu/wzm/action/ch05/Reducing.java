package edu.wzm.action.ch05;

import edu.wzm.action.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/29.
 */
public class Reducing {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
        System.out.println(max.get());

        numbers.stream()
                .reduce(Integer::min)
                .ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
