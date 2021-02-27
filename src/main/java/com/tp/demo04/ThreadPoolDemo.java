package com.tp.demo04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 参考：https://www.cnblogs.com/jfaith/p/11114470.html
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
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executorService2.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable {
    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-----" + i);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


