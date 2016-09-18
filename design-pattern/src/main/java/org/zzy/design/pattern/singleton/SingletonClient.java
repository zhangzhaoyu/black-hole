package org.zzy.design.pattern.singleton;

/**
 * Created by zhaoyu on 16-8-31.
 */
public class SingletonClient {

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.print("Hello");
    }

}
