package com.hillel.lesson9.pool;

public class ThreadPoolMain {

    public static void main(String[] args) {

        //int cpus = Runtime.getRuntime().availableProcessors();

        ThreadPool threadPool = new ThreadPool(2);

        threadPool.execute(() -> System.out.println("Some task"));
        threadPool.execute(() -> System.out.println("Some task"));
        threadPool.execute(() -> System.out.println("Some task"));
        threadPool.execute(() -> System.out.println("Some task"));
        threadPool.execute(() -> System.out.println("Some task"));
        threadPool.execute(() -> System.out.println("Some task"));
    }
}
