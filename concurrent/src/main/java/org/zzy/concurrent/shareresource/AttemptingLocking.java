package org.zzy.concurrent.shareresource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaoyu on 16-9-5.
 */
public class AttemptingLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean capture = lock.tryLock();
        try {
            System.out.println("tryLock(): " + capture);
        } finally {
            if (capture) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(6, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            System.out.println("tryLock2(2, TimeUnit.SECONDS) : " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptingLocking al = new AttemptingLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {setDaemon(true);}
            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired.");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
