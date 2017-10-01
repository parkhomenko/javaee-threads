package com.hillel.lesson9.pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class ThreadPool {

    CustomBlockingQuery queue;
    List<ThreadInPool> threads = new ArrayList<>();

    public ThreadPool(int numberOfThreads) {
        queue = new CustomBlockingQuery(10);

        for (int i = 0; i < numberOfThreads; i++) {
            ThreadInPool threadInPool = new ThreadInPool(queue);
            threads.add(threadInPool);
            Thread thread = new Thread(threadInPool);
            thread.start();
        }
    }

    public void execute(Runnable task) {
        queue.addTask(task);
    }

    public void terminate() {
        /*for (int i = 0; i < threads.size(); i++) {
            threads.get(i).stop();
        }*/

        for (ThreadInPool threadInPool : threads) {
            threadInPool.stop();
        }

        //Anonymous class
        /*threads.forEach(new Consumer<ThreadInPool>() {
            @Override
            public void accept(ThreadInPool threadInPool) {
                threadInPool.stop();
            }
        });*/

        //Lambda
        /*threads.forEach((ThreadInPool threadInPool) -> {
            threadInPool.stop();
        });*/

        //Lambda
        /*threads.forEach((threadInPool) -> {
            threadInPool.stop();
        });*/

        //Lambda
        //threads.forEach(threadInPool -> threadInPool.stop());

        //Method Reference
        threads.forEach(ThreadInPool::stop);
    }
}
