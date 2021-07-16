package com.deout.task;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntIterable implements Iterable<Integer> {

    int[] backed;

    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private int index = 0;
    boolean elementRemoved = false;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return index < backed.length;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return backed[index++];
        }

        public void remove() {
            if (elementRemoved) {
                throw new IllegalStateException("Could not remove from array");
            }
            elementRemoved = true;
            backed[index] = 0;
        }
    }
}