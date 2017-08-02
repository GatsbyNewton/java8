package edu.wzm.action.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by gatsbynewton on 2017/7/30.
 */
public class Laziness {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("filter: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("map: " + n);
                    return n * n;
                });

        List<Integer> twoEvenSquares = stream.collect(Collectors.toList());
        twoEvenSquares.forEach(System.out::println);
    }
}
