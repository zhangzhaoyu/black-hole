package org.zzy.concurrent.singleton;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class Client {

    public volatile static int  counter = 0;

    public static void main(String[] args) {
        long threadBeginTime = System.currentTimeMillis();
        synchronized (Client.class) {
            Tool tool = new AxeTool();
            for (int i = 0; i < 100; i++) {
                // Tool tool = new AxeTool();
                Person person = new Person(tool, "xx" + i);
                Thread thread = new Thread(person);
                thread.start();
            }
        }

        if (counter == 99) {
            System.out.println("cost : " + (System.currentTimeMillis() - threadBeginTime));
        } else {
            System.out.println("fuck: " + counter);
        }
    }
}
