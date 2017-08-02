package edu.wzm.action.ch03;

/**
 * Created by gatsbynewton on 2017/7/26.
 */
public class Apple {

    private Double weight;
    private String color;

    public Apple(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple [weight=" + weight +
                    ", color=" + color + "]";
    }
}
