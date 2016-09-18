package org.zzy.concurrent.singleton;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class AxeTool implements Tool {
    @Override
    public synchronized void useTool(Person person) {
        System.out.println(person.getName() + " use Axe to cut down a tree.");
    }
}
