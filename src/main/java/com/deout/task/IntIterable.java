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

    private int index = 0;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //TODO: Your task is implement this method
            return index < backed.length;

        }

        public Integer next() {
            //TODO: Your task is implement this method
            return backed[index++];
        }

        public void remove() {
            //TODO: Your task is implement this method
            for (int i = 0; i < backed.length; i++) {
                if (backed[i] == index) {
                    for (int j = i; j < backed.length - 1; j++) {
                        backed[j] = backed[j + 1];
                    }
                    break;
                }
            }
            throw new IllegalStateException("Could not remove from array");
        }
    }
}