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
            if (index < 0 || index >= backed.length) {
                throw new IllegalStateException("Could not remove from array");
            } else {

                for (int i = index; i < backed.length - 1; i++) {
                    if (hasNext()) {
                        backed[i] = backed[i + 1];
                    } else {

                        backed[index] = 0;

                        index = 0;
                    }
                }
            }
        }
    }
}