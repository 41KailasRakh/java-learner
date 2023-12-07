package dev.kailas.java8.inAction.stream;

public class Dish {

    private final String name;
    private final boolean vegeterian;
    private final int calaries;
    private final Type type;

    public Dish(String name, boolean vegeterian, int calaries, Type type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calaries = calaries;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public int getCalaries() {
        return calaries;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }

    public enum Type {
        MEAT,FISH,OTHER
    }
}
