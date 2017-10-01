package com.hillel.lesson9.test;

import java.util.Collections;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> result = executorService.submit(new SomeTask());

        Integer integer = result.get();

        System.out.println("I'm here");
        executorService.shutdown();
    }
}

class SomeTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 5 + 5;
    }
}

class SomeTask2 implements Runnable {

    @Override
    public void run() {

    }
}