package edu.wzm.action.ch03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gatsbynewton on 2017/7/27.
 */
public class Lambda {

    public static List<Apple> filter(List<Apple> apples, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples){
            if (predicate.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args){
        /* Sample example */
        Runnable runnable = () -> System.out.println("Hello World");
        runnable.run();

        List<Apple> apples = new ArrayList<Apple>(){
            {
                add(new Apple(18, "red"));
                add(new Apple(15, "greed"));
                add(new Apple(17, "red"));
            }
        };
        List<Apple> result = filter(apples, apple -> "red".equals(apple.getColor()));
        result.stream().forEach(System.out::println);

        Comparator<Apple> comparator = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        apples.sort(comparator);
        System.out.println(apples);
    }
}
