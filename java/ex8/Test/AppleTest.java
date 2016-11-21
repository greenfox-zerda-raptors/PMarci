import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AppleTest {
    @Test
    public void fibo() throws Exception {
        Apple apple = new Apple();
        assertEquals(0, apple.fibo(-2));
        assertEquals(0, apple.fibo(-1));
        assertEquals(0, apple.fibo(0));
        assertEquals(1, apple.fibo(1));
        assertEquals(1, apple.fibo(2));
        assertEquals(2, apple.fibo(3));
        assertEquals(3, apple.fibo(4));
        assertEquals(6765, apple.fibo(20));
    }

    @Test
    public void sum() throws Exception {
        Apple apple = new Apple();
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(1));
        assertEquals(21, apple.sum(arr));
        assertEquals(0, apple.sum(arr2));
        assertEquals(1, apple.sum(arr3));

    }

    @Test
    public void getName() throws Exception {
        Apple myObject = new Apple();
    assertEquals("apple", myObject.getName());
    }

}