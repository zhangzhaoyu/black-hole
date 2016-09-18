package org.zzy.thinkinjava.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(BasicFileOutput.class.getResource("/").getPath() + "test.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("xxxsxxx");

        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        bufferedWriter.close();
        fileWriter.close();
    }
}
