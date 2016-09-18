package org.zzy.concurrent.shareresource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyu on 16-9-2.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(int id, IntGenerator generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCancel()) {
            int val = generator.next();
           /* synchronized (generator) {
                val = generator.next();
            }*/
            System.out.println(Thread.currentThread().getName() + " generator val is :" + val);
            if (val % 2 != 0) {
                System.out.println("odd number is " + val);

                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press Control -C to exit ");
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<count; i++) {
            executorService.execute(new EvenChecker(i, generator));
        }
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}
