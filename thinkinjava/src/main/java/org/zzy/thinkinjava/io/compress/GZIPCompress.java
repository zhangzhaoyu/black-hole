package org.zzy.thinkinjava.io.compress;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class GZIPCompress {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("write file...");
        out.write("zhangzhaoyu".getBytes());
        out.close();

        System.out.println("read file...");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
        bufferedReader.close();
    }
}
