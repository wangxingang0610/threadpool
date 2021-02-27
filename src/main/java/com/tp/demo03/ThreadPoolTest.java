package com.tp.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * new Threa创建线程的缺点：
 * a、new线程性能差
 * b、缺乏统一管理。
 *    无限制创建线程，导致不同线程之间相互竞争；
 *    占用过多资源，可能导致cpu过高；
 *    oom
 * c、缺乏更多功能，如定时执行、定期执行、线程中断
 *
 * 线程池的好处：
 * a、重用存在的线程，减少频繁创建、消亡
 * b、合理控制并发线程数，提高系统资源利用，避免堵塞
 * c、提供定时执行、定期执行、单线程、并发数控制等功能
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("时间：" + (System.currentTimeMillis() - startTime));
        System.out.println("大小：" + list.size());
    }
}
