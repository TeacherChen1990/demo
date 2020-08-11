package demo;


import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> call = () -> {
            //睡他个5秒还要多
            Thread.sleep(5555);
            return "咋回事儿啊";
        };
        Future<String> submit = executorService.submit(call);

        String s = submit.get();

        System.out.println(s);
        executorService.shutdown();
    }
}
