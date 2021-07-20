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

    private int index = 0 ;

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //TODO: Your task is implement this method
            if (index < IntIterable.this.backed.length) {
                return true;
            } else {
                return false;
            }

        }

        public Integer next() {
            //TODO: Your task is implement this method
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return backed[index++];
        }




        public void remove() {
            //TODO: Your task is implement this method
            if(index < 0 || index >= backed.length){
                throw new IllegalStateException("Could not remove from array");


            }else {

                for(int i = index; i < backed.length-1; i++) {
                   if(hasNext()) {backed[i] = backed[i+1];}
                }

        }
    }

}
}
