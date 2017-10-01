package com.hillel.lesson9.races;

public class Races {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Incrementor incrementor = new Incrementor(counter);
        Decrementor decrementor = new Decrementor(counter);

        Thread t1 = new Thread(incrementor);
        Thread t2 = new Thread(decrementor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getValue());
    }
}
