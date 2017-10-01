package com.hillel.lesson9;

public class ThreadExample {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int number : numbers) {
            Printer printer = new Printer(number);
            printer.setDaemon(false);
            printer.setName("Custom Thread - " + number);
            printer.start();
        }

        System.out.println("I'm finished");
    }
}

class Printer extends Thread {

    private int number;

    public Printer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }
}