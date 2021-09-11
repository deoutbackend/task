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
//            return index < backed.length;
            for (int i = 0; i < backed.length; i++) {
                if (i == index && ++i != 0) {
                    return true;
                }
            }
            return false;
        }

        public Integer next() {
            //TODO: Your task is implement this method
//            return backed[index++];
            for (int i = 0; i < backed.length; i++) {
                if (hasNext()) {
                    return backed[index++];
                }
            }
            return 0;
        }

        public void remove() {
            //TODO: Your task is implement this method
            for (int i = 0; i < backed.length; i++) {
                if (backed[i] == index) {
                    if (backed.length - 1 - i >= 0) System.arraycopy(backed, i + 1, backed, i, backed.length - 1 - i);
                    break;
                }
            }
            throw new IllegalStateException("Could not remove from array");
        }
    }
}