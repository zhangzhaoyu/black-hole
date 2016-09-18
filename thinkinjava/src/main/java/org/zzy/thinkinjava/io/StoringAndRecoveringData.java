package org.zzy.thinkinjava.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String fileName = StoringAndRecoveringData.class.getClassLoader().getResource("").getPath() + "test.txt";
        System.out.println(fileName);
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));

        out.writeBoolean(false);
        out.writeDouble(12.23);
        out.writeUTF("zhang");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        System.out.println(in.readBoolean());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

        // Scanner scanner = new Scanner(new File(fileName));
        // System.out.println(scanner.nextLine());
    }
}
