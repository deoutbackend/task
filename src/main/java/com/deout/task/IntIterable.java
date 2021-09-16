package com.deout.task;

import java.util.Iterator;
import java.util.List;

public class IntIterable implements Iterable<Integer> {
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private int index = 0;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return index <= backed.length - 1;

            //TODO: Your task is implement this method
        }

        public Integer next() {
            if (backed == null) return null;

            return backed.length != 0 ? backed[index++] : null;

            //TODO: Your task is implement this method
        }

        public void remove() {
            if (backed.length == 0 || backed == null)
                throw new IllegalStateException("Could not remove from array");

            backed = null;
            index = 0;

            //TODO: Your task is implement this method
        }
    }
}