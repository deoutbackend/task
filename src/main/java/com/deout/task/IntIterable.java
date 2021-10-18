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

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return backed.length > index;
        }

        public Integer next() {
            if (hasNext())
                return backed[index++];

            throw new NoSuchElementException();
        }

        public void remove() {
            int i = index;
            int[] copyArray = backed;
            backed = new int[copyArray.length - 1];
            for (int j = 0; j < backed.length; j++) {
                if (j >= i) {
                    backed[j] = copyArray[j + 1];
                } else {
                    backed[j] = copyArray[j];
                }
            }
        }

    }

}