package org.zzy.concurrent.chapter2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaoyu on 16-9-7.
 */

class IntegerTestThread implements Runnable {
    @Override
    public void run() {
        int x = 0;
        while (x < 1000) {
            synchronized (this) {
                TestAtomic.atomicInteger.incrementAndGet();
                TestAtomic.integer++;
                TestAtomic.intValue++;
                TestAtomic.i++;
                TestAtomic.integerValue++;
                x++;
            }

        }
        ++TestAtomic.endThread;
    }
}

public class TestAtomic {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static volatile Integer integer = 0;
    public static volatile int intValue = 0;

    public static int i = 0;
    public static Integer integerValue = 0;
    public static int endThread = 0;

    public void testAtomic() {
        for (int j = 0; j < 100; j++) {
            new Thread(new IntegerTestThread()).start();
        }
        try {
            for(;;) {
                TimeUnit.MILLISECONDS.sleep(500);
                if (TestAtomic.endThread == 100) {
                    System.out.println(">>Execute End:");
                    System.out.println(">>Atomic: "+TestAtomic.atomicInteger);
                    System.out.println(">>VInteger: "+TestAtomic.integer);
                    System.out.println(">>Integer: "+TestAtomic.integerValue);
                    System.out.println(">>Source i: "+TestAtomic.i);
                    System.out.println(">>Source Vi: "+TestAtomic.intValue);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestAtomic().testAtomic();
    }
}
