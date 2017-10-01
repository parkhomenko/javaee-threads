package com.hillel.lesson9.races;

public class CustomLock {

    private boolean locked;

    public void lock() {
        while (locked) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        locked = true;
    }

    public void unlock() {
        locked = false;
        synchronized (this) {
            notify();
        }
    }
}
