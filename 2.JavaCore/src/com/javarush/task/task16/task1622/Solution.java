package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            Thread st = new SleepingThread();
            Thread.sleep(100);
            st.interrupt();
            st.join();

            //напишите тут ваш код
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (!isInterrupted()) {
                System.out.println(this);
                if (--countDownIndex == 0) return;
                //напишите тут ваш код
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                    return;
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
