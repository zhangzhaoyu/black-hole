package org.zzy.thinkinjava.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class GetChanel {
    private static final int BSIZE = 1024;
    static String fileName = GetChanel.class.getClassLoader().getResource("").getPath() + "test.txt";
    public static void main(String[] args) throws IOException {

        FileChannel fileChannel = new FileOutputStream(new File(fileName)).getChannel();

        fileChannel.write(ByteBuffer.wrap("hello world\n".getBytes()));
        fileChannel.close();

        fileChannel = new RandomAccessFile(fileName, "rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("hello zhangzhaoyu!".getBytes()));
        fileChannel.close();

        fileChannel = new FileInputStream(new File(fileName)).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        System.out.println((char)byteBuffer.get());

        read();

    }

    public static void read() throws IOException {
        FileChannel fileChannel = new FileInputStream(new File(fileName)).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            System.out.println((char)byteBuffer.get());
            byteBuffer.clear();
        }
    }
}
