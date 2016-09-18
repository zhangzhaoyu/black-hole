package org.zzy.concurrent.chapter1;

/**
 * Created by zhaoyu on 16-8-30.
 */
public class Main {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
