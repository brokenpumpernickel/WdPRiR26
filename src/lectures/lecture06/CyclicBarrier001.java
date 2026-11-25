package lectures.lecture06;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier001 {
    static void main() throws InterruptedException {
        Thread[] workers = new Thread[6];

        CyclicBarrier cb = new CyclicBarrier(workers.length);

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread() {
                @Override
                public void run() {
                    Random random = new Random();
                    try {
                        while (true) {
                            sleep(random.nextInt(2000));
                            System.out.println("Job A finished - " + threadId());

                            cb.await();

                            sleep(random.nextInt(2000));
                            System.out.println("Job B finished - " + threadId());

                            cb.await();
                        }
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        }

        for (var t : workers)
            t.start();

        for (var t : workers)
            t.join();
    }
}
