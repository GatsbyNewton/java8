package edu.wzm.action.ch06;

import edu.wzm.action.ch04.Dish;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/8/4.
 */
public class Summarizing {

    public static void main(String[] args){
        System.out.println(calculateCount());

        System.out.println(calculateTotalCalories());

        System.out.println(calculateAverageCalories());

        System.out.println(getIntSummaryStatistics());
    }

    /* count */
    private static long calculateCount(){
        long count =  menu.stream()
                .collect(Collectors.counting());

        return count;
    }

    /* sum */
    private static int calculateTotalCalories(){
        int sum = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        return sum;
    }

    /* average */
    private static double calculateAverageCalories(){
        double average =  menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        return average;
    }

    /* IntSummaryStatistics */
    private static IntSummaryStatistics getIntSummaryStatistics(){
        IntSummaryStatistics summaryStatistics =  menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

        return summaryStatistics;
    }
}
