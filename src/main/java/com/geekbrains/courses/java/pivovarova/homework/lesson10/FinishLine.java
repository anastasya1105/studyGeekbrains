package com.geekbrains.courses.java.pivovarova.homework.lesson10;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinishLine extends Stage{
    Lock lock = new ReentrantLock();

    public FinishLine() {
    }

    @Override
    public void overcome(Car c) {
        if (lock.tryLock()) {
            lock.lock();
            System.out.println(c.getName() + " - WIN");
        }

    }
}
