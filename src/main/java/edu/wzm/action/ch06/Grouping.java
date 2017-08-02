package edu.wzm.action.ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static edu.wzm.action.ch06.Dish.menu;

/**
 * Created by gatsbynewton on 2017/7/30.
 */
public class Grouping {

    public static void main(String[] args){

    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.mapping(Dish::getName, Collectors.toList())));
    }

//    private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
////        return menu.stream()
////                .collect(Collectors.groupingBy(Dish::getType,
////                        flatMapping(dish -> dishTags.get(dish.getName() ).stream(), Collectors.toSet())) );
//        return menu.stream().collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get( dish.getName() ).stream(), toSet())));
//    }
}
