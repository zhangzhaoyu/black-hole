package org.zzy.thinkinjava.io;

import java.io.*;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName)
        );
        String s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = bufferedReader.readLine()) != null ) {
            stringBuffer.append(s + "\n");
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println();
        System.out.println(read(BufferedInputFile.class.getResource("/").getPath()+ "/test.txt"));
    }
}
