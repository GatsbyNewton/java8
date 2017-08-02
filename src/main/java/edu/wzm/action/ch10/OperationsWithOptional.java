package edu.wzm.action.ch10;

import java.util.Optional;

/**
 * Created by didi on 2017/7/31.
 */
public class OperationsWithOptional {

    public static void main(String[] args){

        System.out.println(max(Optional.of(3), Optional.of(5)));

        System.out.println(max(Optional.empty(), Optional.of(5)));

        Optional<Integer> opt1 = Optional.of(5);
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
        return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }
}
