package edu.wzm.action.ch06;

import edu.wzm.action.ch04.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static edu.wzm.action.ch04.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/30.
 */
public class Grouping {

    public static void main(String[] args){
        System.out.println(groupDishesByType());

        System.out.println(groupDishesByCaloricLevel());

        System.out.println(groupDishedByTypeAndCaloricLevel());

        System.out.println(groupDishNamesByType());

        System.out.println(groupMostCaloricByType());

        System.out.println(groupMostCaloricByTypeWithoutOptional());

        System.out.println(groupCaloricLevelByType());
    }

    /* Basic group */
    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
    }

    /* Condition group */
    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }));

        return dishesByCaloricLevel;
    }

    /* multiple level group */
    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dishTags -> {
                            if (dishTags.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dishTags.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        })
                ));
    }

    /*  */
    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(Dish::getName, Collectors.toList())));
    }

    /* group with Optional */
    private static Map<Dish.Type, Optional<Dish>> groupMostCaloricByType(){
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
    }

    /* group with Optional, and get its value by Collectors.collectingAndThen() */
    private static Map<Dish.Type, Dish> groupMostCaloricByTypeWithoutOptional(){
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }

    /* group with mapping */
    private static Map<Dish.Type, Set<CaloricLevel>> groupCaloricLevelByType(){
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }, Collectors.toCollection(HashSet::new))));
    }

    enum CaloricLevel{
        DIET,
        NORMAL,
        FAT,
    }
}
