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
        //TODO: Your task is implement this method
        public boolean hasNext() {
            return index < backed.length && backed[index] != 0;

        }

        public Integer next() {
            //TODO: Your task is implement this method
            if (backed[index++] != 0) {
                return backed[index++];
            }
            return 0;
        }

        public void remove() {
            //TODO: Your task is implement this method
            int[] newArr = new int[backed.length - 1];
            for (int i = 0, j = 0; i < backed.length; i++) {
                if (i == index) {
                    continue;
                }
                newArr[j++] = backed[i];
            }
            // set link to new array without deleted element
            backed = newArr;
            throw new IllegalStateException("Could not remove from array");
        }
    }
}