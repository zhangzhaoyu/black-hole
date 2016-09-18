package org.zzy.thinkinjava.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhaoyu on 16-9-12.
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            String[] cmds = {"/bin/sh","-c","ps -ef|grep java"};
            Process process = new ProcessBuilder(cmds).start();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((str = bufferedReader.readLine()) != null) {
                System.err.println(str);
                err = true;
            }

            bufferedReader.close();
            errors.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (err) {
            throw new RuntimeException("execute error.");
        }
    }

    public static void main(String[] args) {
        OSExecute.command("javac");
    }
}
