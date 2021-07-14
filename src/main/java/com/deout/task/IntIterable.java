package com.deout.task;

import java.util.Iterator;

public class IntIterable implements Iterable<Integer> {
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private int index = 0 ;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //TODO: Your task is implement this method
            return false;
        }

        public Integer next() {
            //TODO: Your task is implement this method
            return 0;
        }

        public void remove() {
            //TODO: Your task is implement this method
            throw new IllegalStateException("Could not remove from array");
        }
    }
}