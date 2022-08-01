package com.company;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.Callable;


public class Main {
    static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {

        Shop shop = new Shop("First");
        Shop shopTwo = new Shop("Second");
        Shop shopThree = new Shop("Third");

        shop.start();
        shopTwo.start();
        shopThree.start();

        System.out.println(longAdder.sum());

    }

    static class Shop extends Thread {
        final Random random = new Random();

        public Shop(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                int[] earnings = new int[10];
                for (int i = 0; i < earnings.length; i++) {
                    earnings [i] = random.nextInt(1000);
                    longAdder.add(earnings[i]);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

}
