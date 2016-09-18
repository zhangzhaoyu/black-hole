package org.zzy.thinkinjava.generic;

/**
 * Created by zhaoyu on 16-9-1.
 */
public class TwoTuple<A, B> {

    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    private final D four;

    public FourTuple(A first, B second, C third, D four) {
        super(first, second, third);
        this.four = four;
    }
}

class TupleTest {
    public static void main(String[] args) {
        System.out.println(f().first);
        System.out.println(f().second);
    }

    private static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("zhang", 12);
    }
}
