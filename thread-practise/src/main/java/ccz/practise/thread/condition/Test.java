package ccz.practise.thread.condition;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 46043 on 2017/7/14.
 */
public class Test {

    public static void main(String[] args) {
        final Something something = new Something();
        int produceThreadNum = RandomUtils.nextInt(7, 10);
        int consumerThreadNum = RandomUtils.nextInt(1, 3);
        System.out.println("produce thread num:" + produceThreadNum);
        System.out.println("consumer thread num:" + consumerThreadNum);
        for (int i = 0; i < produceThreadNum; i++) {
            new Thread(()->{
                while (true) {
                    try {
                        Thread.sleep(RandomUtils.nextInt(3, 5) * 100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    something.increase();
                }
            }).start();
        }

        for (int i = 0; i < consumerThreadNum; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(RandomUtils.nextInt(1, 2) * 100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    something.decrease();
                }
            }).start();
        }
    }
}

class Something {
    private int count;
    final private int MAX = 5;
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public void increase() {
        try {
            lock.lock();
            while (count == MAX) {
                notFull.await();
            }
            System.out.println(Thread.currentThread().getName() + ":produce:" + ++count);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        try {
            lock.lock();
            while(count==0) {
                notEmpty.await();
            }
            System.out.println(Thread.currentThread().getName() + ":concumer:" + --count);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
