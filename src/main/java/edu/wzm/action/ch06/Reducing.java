package edu.wzm.action.ch06;

import edu.wzm.action.ch04.Dish;

import java.util.stream.Collectors;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/30.
 */
public class Reducing {

    public static void main(String[] args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
    }

    /**
     * reducing()
     * @return
     */
    private static int calculateTotalCalories() {
        return menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .get();
    }

    /**
     * IntStream
     * @return
     */
    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }
}