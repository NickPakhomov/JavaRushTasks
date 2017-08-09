package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        AtomicInteger counter = new AtomicInteger(1);
        while (true) {
            try {
                Thread.sleep(500);
                map.put(String.valueOf(counter.get()), String.format("Some text for %d", counter.get()));
                counter.incrementAndGet();
            } catch (InterruptedException e) {
                System.out.println(String.format("[thread-%d] thread was terminated.", Thread.currentThread().getId()));
                return;
            }
        }
    }
}
