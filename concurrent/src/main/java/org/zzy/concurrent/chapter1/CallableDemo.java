package org.zzy.concurrent.chapter1;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by zhaoyu on 16-9-1.
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i=0; i<10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {
            if (fs.isDone())
                System.out.println(fs.get());
            else
                System.out.println(fs.get(1, TimeUnit.SECONDS));
        }
        executorService.shutdown();
    }
}
