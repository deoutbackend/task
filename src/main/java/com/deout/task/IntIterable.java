package com.deout.task;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

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
            while (index < backed.length){
                return true;
            }
            return false;
        }

        public Integer next() {
            //TODO: Your task is implement this method
            if(!hasNext())
                throw new NoSuchElementException();
            return backed[index++];
        }

        public void remove() {
            //TODO: Your task is implement this method
            if (backed == null || index < 0 || index >= backed.length){
                throw new IllegalStateException();
            }
            IntStream.range(0, backed.length).filter(i -> i != index).map(i -> backed[i]).toArray();
        }

    }
}