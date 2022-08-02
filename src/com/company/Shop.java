package com.company;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread{
    final Random random = new Random();
    LongAdder longAdder;

    public Shop(String name, LongAdder longAdder) {
        super(name);
        this.longAdder = longAdder;
    }

    @Override
    public void run() {
        try {
            int[] earnings = new int[10];
            for (int i = 0; i < earnings.length; i++) {
                earnings[i] = random.nextInt(1000);
                longAdder.add(earnings[i]);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
