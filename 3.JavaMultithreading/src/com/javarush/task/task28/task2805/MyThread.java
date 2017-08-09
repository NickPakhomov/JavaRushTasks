package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static volatile int priority = Thread.MIN_PRIORITY;

    public MyThread() {
        setPriority(priority);
        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(priority);
        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(priority > group.getMaxPriority() ? group.getMaxPriority() : priority);

        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(String name) {
        super(name);
        setPriority(priority);
        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(priority > group.getMaxPriority() ? group.getMaxPriority() : priority);

        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(priority);
        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(priority > group.getMaxPriority() ? group.getMaxPriority() : priority);

        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(priority > group.getMaxPriority() ? group.getMaxPriority() : priority);

        priority = priority + 1 > Thread.MAX_PRIORITY ? Thread.MIN_PRIORITY : priority + 1;
    }
}
