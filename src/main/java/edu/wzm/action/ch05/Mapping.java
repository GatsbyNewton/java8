package edu.wzm.action.ch05;

import edu.wzm.action.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import static java.util.stream.Collectors.toList;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/29.
 */
public class Mapping {

    public static void main(String[] args){
        /* map */
        List<String> dishNames = menu.stream()
                                    .map(Dish::getName)
                                    .collect(toList());
        System.out.println(dishNames);
        System.out.println("============== map =============");

        /* map-map */
        List<Integer> dishNameLength = menu.stream()
                                    .map(Dish::getName)
                                    .map(String::length)
                                    .collect(toList());
        System.out.println(dishNameLength);
        System.out.println("=========== map-map ============");

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                    .map(String::length)
                                    .collect(toList());
        System.out.println(wordLengths);
        System.out.println("============== map =============");

        /* flatMap() */
        List<String> wordList = words.stream()
                .flatMap(d -> Arrays.stream(d.split("")))
                .distinct()
                .collect(toList());
        System.out.println(wordList);
        System.out.println("============== flatMap =============");

        /* flatMap() */
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> pairs = number1.stream()
                                    .flatMap(i ->
                                                number2.stream()
                                                        .filter(j -> (i + j) % 3 == 0)
                                                        .map(j -> new int[]{i, j})
                                    ).collect(toList());
        System.out.println(pairs);
        System.out.println("============== flatMap =============");
    }
}
