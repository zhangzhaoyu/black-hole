package org.zzy.thinkinjava.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class DetailsBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(24);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
    }
}
