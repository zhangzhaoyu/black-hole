package org.zzy.thinkinjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class ConsoleReader {
    public static String readByReader() throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static String readByScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readByReader());
        System.out.println(readByScanner());
    }
}
