package org.zzy.thinkinjava.io.compress;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);

        zipOutputStream.setComment("A test of Java Zipping.");
        for (String arg : args) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(arg));
            zipOutputStream.putNextEntry(new ZipEntry(arg));

            int c;
            while ((c = bufferedReader.read()) != -1) {
                bufferedOutputStream.write(c);
            }
            bufferedReader.close();
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.close();



    }
}
