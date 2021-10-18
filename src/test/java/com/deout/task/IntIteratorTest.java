package com.deout.task;


import org.junit.Test;

import static org.junit.Assert.*;

public class IntIteratorTest {

    @Test
    public void testForeach() {
        int[] arr = {1, 2, 3, 4, 5};
        IntIterable intIterable = new IntIterable(arr);
        Integer i = 0;
        for (Integer el : intIterable) {
            assertEquals(i + " element doesn't match", Integer.valueOf(arr[i]), el);
            i++;
        }
        assertEquals("Didn't went throw array", i, Integer.valueOf(arr.length));
    }

    @Test
    public void testBlankForeach() {
        int[] arr = new int[0];
        for (Integer el : new IntIterable(arr)) {
            fail("Shouldn't come here");
        }
    }

    @Test
    public void testRemoveElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 4, 5};
        int i = 0;
        IntIterable intIterable = new IntIterable(arr);
        while (intIterable.iterator().hasNext()) {
            if (arr[i] == 3)
                intIterable.iterator().remove();
            intIterable.iterator().next();
            i++;
        }
        assertArrayEquals("arrays are not equal", intIterable.backed, arr1);
    }

}
