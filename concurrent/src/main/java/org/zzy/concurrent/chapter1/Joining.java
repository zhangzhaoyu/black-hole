package org.zzy.concurrent.chapter1;

/**
 * Created by zhaoyu on 16-9-2.
 */

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. "
                    + " isInterrupted() : " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened.");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println(getName() + " join completed.");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleeper),
                doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}
