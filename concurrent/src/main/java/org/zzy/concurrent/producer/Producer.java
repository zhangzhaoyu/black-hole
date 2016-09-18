package org.zzy.concurrent.producer;

import java.util.concurrent.*;

/**
 * Created by zhaoyu on 16-9-6.
 */

class Item {
    private static int itemCount = 0;

    private String name;
    private Integer id = ++itemCount;

    public Item() {
        this.name = "name" + this.id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class Storage {
    private static int MAX_SIZE = 5;
    private LinkedBlockingQueue<Item> storage = new LinkedBlockingQueue<>();

    public synchronized void produce() throws InterruptedException {
        while (true) {
            if (storage.size() == MAX_SIZE) {
                this.wait();
            }
            else {
                Item item = new Item();
                this.storage.add(item);
                this.notify();

                System.out.println(Thread.currentThread().getName() + " : Producer produces a " + item);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
    }

    public synchronized  void consume() throws InterruptedException {
        while (true) {
            if (storage.size() == 0) {
                this.wait();
            }
            else {
                Item item = this.storage.poll();
                this.notifyAll();
                if (item == null) {
                    System.out.println("xxx");
                }
                System.out.println(Thread.currentThread().getName() + " : consumer consumes a " + item);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
    }

}

class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public synchronized void consume() throws InterruptedException {
        storage.consume();
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
        }

    }
}

public class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void produce() throws InterruptedException {
        storage.produce();
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer = new Producer(storage);
        Consumer
                consumer1 = new Consumer(storage),
                consumer2 = new Consumer(storage),
                consumer3 = new Consumer(storage);

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(producer);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        service.shutdown();
    }
}
