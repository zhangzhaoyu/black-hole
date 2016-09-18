package org.zzy.concurrent.interrupting;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyu on 16-9-7.
 */
public class CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();

        executorService.execute(new IOBlocking(socketInput));
        executorService.execute(new IOBlocking(System.in));

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shutdown all threads.");
        executorService.shutdownNow();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing " + socketInput.getClass().getSimpleName());
        socketInput.close();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getSimpleName());
        System.in.close();
    }
}
