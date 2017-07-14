package ccz.practise.thread.executor;

import java.util.concurrent.*;

/**
 * Created by 46043 on 2017/6/26.
 */
public class ExecutorPractise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {
            public String call() throws Exception {
                //Thread.sleep(10000L);
                return "hello";
            }
        });
        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}
