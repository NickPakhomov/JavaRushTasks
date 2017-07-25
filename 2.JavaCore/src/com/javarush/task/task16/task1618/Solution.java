package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread testThread = new TestThread();
        testThread.start();
        Thread.sleep(3000);
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        private int counter = 0;
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    return;
                }
                System.out.println(++counter);
            }
        }
    }
}