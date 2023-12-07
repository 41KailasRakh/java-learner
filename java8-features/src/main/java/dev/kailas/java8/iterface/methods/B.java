package dev.kailas.java8.iterface.methods;

public interface B {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
