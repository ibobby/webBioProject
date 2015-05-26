package ru.bobby.web;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by User on 24.05.2015.
 */
public class TestOfTest {

    @Test
    public void first() {
        System.out.println("FIRST TEST METHOD");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void second() {
        System.out.println("SECOND TEST METHOD");
        System.out.println(Thread.currentThread().getName());
    }

    @Test(timeout = 6000)
    public void third() throws InterruptedException {
        System.out.println("THIRD TEST METHOD");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWithException() throws Throwable {
        System.out.println(Thread.currentThread().getName());
        throw new FileNotFoundException();
        //throw new Throwable();
    }

}
