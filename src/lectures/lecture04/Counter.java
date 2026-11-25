package lectures.lecture04;

//public class Counter {
//    private int count = 0;
//
//    public int getAndIncrement() {
//        return count++;
//    }
//
//    static void main() {
//        Counter counter = new Counter();
//        for(int i = 0; i < 10; i++) {
//            System.out.println(counter.getAndIncrement());
//        }
//    }
//}

import java.util.concurrent.locks.ReentrantLock;

//public class Counter {
//    private ReentrantLock lock = new ReentrantLock();
//    private int count = 0;
//
//    public int getAndIncrement() {
//        lock.lock();
//        int tmp = count++;
//        lock.unlock();
//        return tmp;
//    }
//
//    static void main() {
//        Counter counter = new Counter();
//        for(int i = 0; i < 10; i++) {
//            System.out.println(counter.getAndIncrement());
//        }
//    }
//}

//public class Counter {
//    private ReentrantLock lock = new ReentrantLock();
//    private int count = 0;
//
//    public int getAndIncrement() {
//        lock.lock();
//        try {
//            return count++;
//        } finally {
//            lock.unlock();
//        }
//
//    }
//
//    static void main() {
//        Counter counter = new Counter();
//        for(int i = 0; i < 10; i++) {
//            System.out.println(counter.getAndIncrement());
//        }
//    }
//}

public class Counter {
    private int count = 0;

    synchronized public int getAndIncrement() {
        return count++;
    }

    static void main() {
        Counter counter = new Counter();
        for(int i = 0; i < 10; i++) {
            System.out.println(counter.getAndIncrement());
        }
    }
}