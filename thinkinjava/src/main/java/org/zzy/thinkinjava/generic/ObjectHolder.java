package org.zzy.thinkinjava.generic;

/**
 * Created by zhaoyu on 16-9-1.
 */
public class ObjectHolder {

    private Object object;

    public ObjectHolder(Object object) {
        this.object = object;
    }

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return this.object;
    }

    public static void main(String[] args) {
        ObjectHolder objectHolder = new ObjectHolder("aaa");
        String str = (String) objectHolder.get();
        System.out.println(str);
    }

}

class GenericHolder<T> {
    private T t;

    public GenericHolder(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }
}
