package com.hillel.lesson9;

public class AnotherExample {

    public static void main(String[] args) {
        final String test = "hello";
        Thread thread = new Thread(() -> System.out.println(args[0]));
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
