package edu.wzm.action.ch06;

import edu.wzm.action.ch04.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/8/4.
 */
public class Partitioning {

    public static void main(String[] args){
        System.out.println(partitionedMenu());

        System.out.println(partitionedVegetarianDishesByType());

        System.out.println(partitionedMostCaloricParitionedByvegeterian());

        System.out.println(partitionPrimes(100));
    }

    private static Map<Boolean, List<Dish>> partitionedMenu(){
        return menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Dish.Type, List<Dish>>> partitionedVegetarianDishesByType(){
        return menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.groupingBy(Dish::getType)));
    }

    /* partition with Optional, and get its value by Collectors.collectingAndThen() */
    private static Map<Boolean, Dish> partitionedMostCaloricParitionedByvegeterian(){
        return menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }

    /* partition by primes */
    private static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    /* Judge numbers if they are prime */
    private static boolean isPrime(int candidate){
        return IntStream.rangeClosed(2, (int)Math.sqrt(candidate))
                .noneMatch(i -> candidate % i == 0);
    }
}
