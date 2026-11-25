package lectures.lecture06;

import lectures.lecture04.Helpers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatch001 {
    static void main() throws InterruptedException {
        long start = 0;
        long end = 0;

        start = System.nanoTime();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatch cdl = new CountDownLatch(50);
        for(int n = 0; n < 50; ++n) {
            int nn = n;
            ex.execute(() -> {
                System.out.println(nn + " " + Helpers.fibon(nn));
                cdl.countDown();
            });
        }

        cdl.await();
        System.out.println("Everything is ready!");

        ex.shutdown();
        ex.awaitTermination(1, TimeUnit.DAYS);
        end = System.nanoTime();
        System.out.println("Time (pool): " + (end - start) / 1000000000.0);
    }
}
