package org.zzy.thinkinjava.io;

import java.io.*;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class TextFile {

    public static String read(File file) {
        StringBuffer stringBuffer = new StringBuffer();

        try {
            if (file == null) {
                throw new NullPointerException("file is null.");
            }
            if (!file.exists()) {
                throw new FileNotFoundException("file not found exception.");
            }
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("It is a directory.");
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            try {
                while ((s = reader.readLine()) != null) {
                    stringBuffer.append(s);
                }
            } finally {
                reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("xxx.out");
        file.createNewFile();

        File file1 = file.getAbsoluteFile();
        File file2 = file.getCanonicalFile();
    }

}
