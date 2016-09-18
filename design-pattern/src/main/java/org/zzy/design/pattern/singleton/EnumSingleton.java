package org.zzy.design.pattern.singleton;

/**
 * Created by zhaoyu on 16-8-31.
 */
public enum  EnumSingleton {

    INSTANCE;

    public void print(String name) {
        System.out.println("Hello : " + name);
    }

}
