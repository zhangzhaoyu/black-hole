package org.zzy.design.pattern.singleton;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class StaticSingleton implements Serializable {

    private static final StaticSingleton INSTANCE = new StaticSingleton();

    private StaticSingleton() {}

    public static StaticSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 解决反序列化问题
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
