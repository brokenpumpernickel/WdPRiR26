package lectures.lecture07;

import lectures.lecture04.Counter;
import lectures.lecture04.Helpers;

import java.util.concurrent.atomic.AtomicInteger;

public class Primers {
    public static class Worker extends Thread {
        private AtomicInteger counter;
        private int count = 0;

        public Worker(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            int number;

            while((number = counter.getAndIncrement()) < 1000000) {
                if(Helpers.isPrime(number))
                    System.out.println(number + " / " + threadId());
                ++count;
            }

            System.out.println("The Final Countdown is " + count + " / " + threadId());
        }

        public int getCount() {
            return count;
        }
    }

    static void main() throws InterruptedException {


        AtomicInteger counter = new AtomicInteger();

        long start = System.nanoTime();

        //Worker[] workers = new Worker[16];
        Worker[] workers = new Worker[Runtime.getRuntime().availableProcessors()];

        for(int i = 0; i < workers.length; ++i) {
            workers[i] = new Worker(counter);
            // workers[i].start(); // Nie róbcie tego w domu!
            // workers[i].join();
        }

        for (Worker worker : workers) worker.start();

        for (Worker worker : workers) worker.join();

        long stop = System.nanoTime();

        System.out.println("Time = " + (stop - start) / 1000000000.0);

        int totalCount = 0;
        for (Worker worker : workers) totalCount += worker.getCount();

        System.out.println("Total numbers processed: " + totalCount);
    }
}
