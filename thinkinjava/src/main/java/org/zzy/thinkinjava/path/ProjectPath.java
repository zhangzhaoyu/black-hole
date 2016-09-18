package org.zzy.thinkinjava.path;

import java.io.*;
import java.util.ResourceBundle;

/**
 * Created by zhaoyu on 16-9-9.
 */
public class ProjectPath {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        System.out.println(ProjectPath.class.getResource("org"));   // null
        System.out.println(ProjectPath.class.getClassLoader().getResource("org")); // not null

        System.out.println(ProjectPath.class.getResource("/org"));   // not null
        System.out.println(ProjectPath.class.getClassLoader().getResource("/org")); // null

        // classpath
        System.out.println(ProjectPath.class.getResource("")); // current file classpath
        System.out.println(ProjectPath.class.getResource("/")); // classpath
        System.out.println(ProjectPath.class.getClassLoader().getResource("").getPath()); // classpath
        System.out.println(ProjectPath.class.getClassLoader().getResource("/")); // null

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath()); // classpath

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages/messages");

        File file = new File("/"); // path /
        File file2 = new File(""); // parent project path
        System.out.println(file.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());

        System.out.println("ClassLoader.getSystemClassLoader() : " + ClassLoader.getSystemClassLoader().getResource("").getPath());

        File file1 = new File(ProjectPath.class.getClassLoader().getResource("").getPath() + "test.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        String name = "hello zhangzhaoyu";
        bufferedOutputStream.write(name.getBytes());
        bufferedOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file1);
        byte[] temp = new byte[10];
        String str = "";
        while (fileInputStream.read(temp) > 0) {
            str = str + new String(temp);
        }
        System.out.println(str);
        System.out.println(ClassLoader.getSystemClassLoader().getResource("./"));

    }
}
