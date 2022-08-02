package com.company;

import java.util.Random;
import java.util.concurrent.atomic.LongAdder;


public class Main {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();

        Shop shop = new Shop("First", longAdder);
        Shop shopTwo = new Shop("Second", longAdder);
        Shop shopThree = new Shop("Third", longAdder);

        shop.start();
        shopTwo.start();
        shopThree.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }


        System.out.println(longAdder.sum());

    }


}

