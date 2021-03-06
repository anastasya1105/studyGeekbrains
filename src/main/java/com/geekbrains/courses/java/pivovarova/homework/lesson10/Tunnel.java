package com.geekbrains.courses.java.pivovarova.homework.lesson10;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    final Semaphore semaphore = new Semaphore(Race.COMPETITORS_COUNT/2);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";

    }

    @Override
    public void overcome(Car c) {

        try {
            try {

                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
