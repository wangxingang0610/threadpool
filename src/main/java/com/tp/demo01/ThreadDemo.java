package com.tp.demo01;

/**
 *
 */
public class ThreadDemo extends Thread{

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {
//        new ThreadDemo("1111").run();//对象调用的普通方法
        new ThreadDemo("222").start();//启用多线程
    }
}
