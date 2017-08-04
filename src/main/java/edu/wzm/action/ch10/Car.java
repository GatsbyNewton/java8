package edu.wzm.action.ch10;

import java.util.Optional;

/**
 * Created by gatsbynewton on 2017/7/31.
 */
public class Car {

    private Optional<Insurance> insurance;

    public Car(Insurance insurance) {
        this.insurance = Optional.ofNullable(insurance);
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
