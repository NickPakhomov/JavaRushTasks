package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

import static com.javarush.task.task16.task1619.Solution.TestThread.isCancelled;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod(t);
    }

    public static void ourInterruptMethod(Thread t) {
        isCancelled = true;
    }

    public static class TestThread implements Runnable {
        public static boolean isCancelled = false;
        public void run() {
            while (!isCancelled) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
