package com.tp.demo05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *     public ThreadPoolExecutor(int corePoolSize, 核心线程数
 *                               int maximumPoolSize, 非核心线程数
 *                               long keepAliveTime, 时间
 *                               TimeUnit unit, 时间单位
 *                               BlockingQueue<Runnable> workQueue,队列
 *                               ThreadFactory threadFactory,线程工程
 *                               RejectedExecutionHandler handler) 拒绝策略
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
        for (int i = 1; i < 100; i++) {
            threadPoolExecutor.execute(new MyTask(i));
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

