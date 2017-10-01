package com.hillel.lesson9.pool;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQuery {

    private Queue<Runnable> queue;

    private int size;

    public CustomBlockingQuery(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public synchronized void addTask(Runnable task) {
        if (queue.size() >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.add(task);
        size++;
        notifyAll();
    }

    public synchronized Runnable pollTask() {

        if (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        size--;
        Runnable task = queue.poll();
        notifyAll();

        return task;
    }
}
