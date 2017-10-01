package com.hillel.lesson9.pool;

public class ThreadInPool implements Runnable {

    private boolean finished;

    private CustomBlockingQuery queue;

    public ThreadInPool(CustomBlockingQuery queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!finished) {
            Runnable task = queue.pollTask();
            task.run();
        }
    }

    public void stop() {
        finished = true;
    }
}
