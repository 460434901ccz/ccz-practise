package ccz.practise.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 46043 on 2017/7/11.
 */
public class Test {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            Lock lock = new ReentrantLock();
            public void run() {
               // lock.lock();
                System.out.println(Thread.currentThread().getName());
                boolean b = true;
                while(b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
