package dev.kailas.java8.iterface.methods;

public interface Sized {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
