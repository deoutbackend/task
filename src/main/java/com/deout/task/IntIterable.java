package com.deout.task;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class IntIterable implements Iterable<Integer> {
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private int index = 0 ;
    private boolean canRemove = false;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return index < backed.length;
        }

        public Integer next() {
            if (hasNext()) {
                return backed[index++];
            }
            throw new NoSuchElementException();
        }

        public void remove() {

            if (!hasNext()) {
                throw new IllegalStateException("Could not remove from array");
            }

            if (index > 0) {
                index--;
            }

            backed = ArrayUtils.remove(backed, index);
        }
    }
}