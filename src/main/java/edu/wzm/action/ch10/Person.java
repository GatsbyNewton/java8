package edu.wzm.action.ch10;

import java.util.Optional;

/**
 * Created by didi on 2017/7/31.
 */
public class Person {

    private Optional<Car> car;

    public Person(Car car) {
        this.car = Optional.ofNullable(car);
    }

    public Optional<Car> getCar() {
        return car;
    }
}
