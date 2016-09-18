package org.zzy.concurrent.chapter2;

/**
 * Created by zhaoyu on 16-9-6.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int next() {
        return serialNumber++;
    }
}
