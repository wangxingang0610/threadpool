package com.tp.demo02;

import com.tp.demo01.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * join参考
 * https://www.cnblogs.com/huangzejun/p/7908898.html
 */
public class TheadTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Thread  t1 = new Thread(){
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            t1.start();//启动多线程
            System.out.println(t1.getName() + "，i="  + i);
            t1.join();//等待线程t1执行完，再继续执行
        }

        System.out.println("时间：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("大小：" + list.size());
    }
}
