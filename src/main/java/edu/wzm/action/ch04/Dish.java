package edu.wzm.action.ch04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gatsbynewton on 2017/7/27.
 */
public class Dish {

    public static final List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                                                        new Dish("beef", false, 700, Dish.Type.MEAT),
                                                        new Dish("chicken", false, 400, Dish.Type.MEAT),
                                                        new Dish("french fries", true, 530, Dish.Type.OTHER),
                                                        new Dish("rice", true, 350, Dish.Type.OTHER),
                                                        new Dish("season fruit", true, 120, Dish.Type.OTHER),
                                                        new Dish("pizza", true, 550, Dish.Type.OTHER),
                                                        new Dish("prawns", false, 400, Dish.Type.FISH),
                                                        new Dish("salmon", false, 450, Dish.Type.FISH));

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public static final Map<String, List<String>> dishTags = new HashMap<>();

    static {
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public static List<Dish> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type{
        MEAT, FISH, OTHER
    }
}
