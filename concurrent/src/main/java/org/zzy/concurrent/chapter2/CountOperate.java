package org.zzy.concurrent.chapter2;

/**
 * Created by zhaoyu on 16-9-9.
 */
public class CountOperate extends Thread {
    @Override
    public void run() {
        System.out.println("this.isAlive() : " + this.isAlive());
    }

    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.start();
    }
}
