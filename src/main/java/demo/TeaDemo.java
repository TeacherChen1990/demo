package demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 泡茶Demo演示
 * 洗茶壶、烧开水、洗茶杯、拿茶叶
 */
@Slf4j
public class TeaDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        FutureTask<String> ft2 = new FutureTask<>(new Task2());
        FutureTask<String> ft1 = new FutureTask<>(new Task1(ft2));
        executorService.submit(ft2);
        executorService.submit(ft1);
        String s = ft1.get();
        System.out.println(s);
        executorService.shutdown();
    }
    public static class Task1 implements Callable<String>{
        private FutureTask<String> task2;

        public Task1(FutureTask<String> task2) {
            this.task2 = task2;
        }
        @Override
        public String call() throws Exception {
            long l = System.currentTimeMillis();
            System.out.println("洗茶壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("烧开水");
            TimeUnit.SECONDS.sleep(15);
            String s = task2.get();
            long l1 = System.currentTimeMillis();
            log.info("task2任务完成，{},耗时：{}",s);
            return "T1小妹：请上茶";
        }
    }
    public static class Task2 implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("洗茶杯");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("拿茶叶");
            TimeUnit.SECONDS.sleep(1);
            return "茶，企茶茶企茶茶";
        }
    }
}
