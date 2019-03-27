package com.bride.client.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、可重用锁ReentrantLock和Condition
 * <p>2、join和interrupt
 * <p>Created by shixin on 2018/9/27.
 */
public class ReentrantLockClient {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        final ReentrantLockClient client = new ReentrantLockClient();
//        client.method();

        client.waitMethod();
        client.signalMethod();
    }

    public void method() {
        lock.lock();
        System.out.println("method "+lock.getHoldCount());
        method2();
        lock.unlock();
    }

    public void method2() {
        lock.lock();
        System.out.println("method2 "+lock.getHoldCount());
        lock.unlock();
    }

    public void waitMethod() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("before wait");
                    condition.await();
                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        thread1.start();
    }

    public void signalMethod() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("before signal");
                condition.signal();
                System.out.println("after signal");
                lock.unlock();
            }
        }).start();
    }
}