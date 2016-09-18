package org.zzy.thinkinjava.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class BufferToText {
    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("some text".getBytes()));
        fileChannel.write(ByteBuffer.wrap("hoho".getBytes()));
        fileChannel.close();

        fileChannel = new FileInputStream("data2.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        System.out.println(byteBuffer.asCharBuffer());
        // byteBuffer.rewind();

        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        String result = Charset.forName(encoding).decode(byteBuffer).toString();
        System.out.println(result);
        fileChannel.close();

        fileChannel = new FileOutputStream("data2.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("zhangzhaoyu".getBytes("UTF-16BE")));
        fileChannel.close();

        fileChannel = new FileInputStream("data2.txt").getChannel();
        byteBuffer.clear();
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());

    }
}
