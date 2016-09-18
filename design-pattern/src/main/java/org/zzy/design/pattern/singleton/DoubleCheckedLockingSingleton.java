package org.zzy.design.pattern.singleton;

/** Lazy load thread safe
 * Created by zhaoyu on 16-8-31.
 */
public class DoubleCheckedLockingSingleton {

    private volatile DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton() {}

    public DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }

}
