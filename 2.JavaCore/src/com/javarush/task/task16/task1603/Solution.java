package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        list.add(new Thread(new SpecialThread(1000, 0)));
        list.add(new Thread(new SpecialThread(2000, 1)));
        list.add(new Thread(new SpecialThread(3000, 2)));
        list.add(new Thread(new SpecialThread(4000, 3)));
        list.add(new Thread(new SpecialThread(5000, 4)));

        list.forEach(Thread::run);
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable  {
        int timeout;
        int count;
        SpecialThread(int timeout, int count) {
            this.timeout = timeout;
            this.count = count;
        }
        public void run() {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("it's a run method inside SpecialThread" + count);
        }
    }
}
