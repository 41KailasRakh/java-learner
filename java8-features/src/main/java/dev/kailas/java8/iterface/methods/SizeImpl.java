package dev.kailas.java8.iterface.methods;

public class SizeImpl implements Sized,B{
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return Sized.super.isEmpty();
    }

}
