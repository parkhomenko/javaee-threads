package com.hillel.lesson9.races;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int value;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

//    private Lock lock = new ReentrantLock();
    private CustomLock lock = new CustomLock();

    public int getValue() {
        return value;
    }

    public void increment() {
        lock.lock();
        value++;
        lock.unlock();
    }

    public void decrement() {
        lock.lock();
        value--;
        lock.unlock();
    }
}
