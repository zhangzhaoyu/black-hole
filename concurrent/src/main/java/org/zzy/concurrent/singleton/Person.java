package org.zzy.concurrent.singleton;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class Person implements Runnable {
    private Tool tool;
    private String name;

    public Person(Tool tool, String name) {
        this.tool = tool;
        this.name = name;
    }

    @Override
    public synchronized void run() {
        Client.counter = Client.counter + 1;
        tool.useTool(this);
    }

    public String getName() {
        return name;
    }
}
