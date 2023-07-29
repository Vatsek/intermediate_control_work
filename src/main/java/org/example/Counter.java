package org.example;

public class Counter implements AutoCloseable {

    private int counter;
    private boolean closed;

    public Counter() {
        closed = false;
    }

    public int getCounter() {
        return counter;
    }


    @Override
    public void close() {
        closed = true;
    }

    public void add() {
        if (closed) {
            throw new RuntimeException("Счетчик вне блока try_with_resources");
        }
        counter++;
    }
}
