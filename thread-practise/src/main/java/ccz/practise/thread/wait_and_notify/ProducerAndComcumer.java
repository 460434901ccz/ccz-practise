package ccz.practise.thread.wait_and_notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 46043 on 2017/6/29.
 */
public class ProducerAndComcumer {
    public static void main(String[] args) {
        Queue queue = new Queue();

        Random random = new Random();
        int producerNum = 0;
        while(producerNum==0) producerNum = random.nextInt(10);

        int comsumerNum = 0;
        while(comsumerNum==0) comsumerNum = random.nextInt(10);

        System.out.println("producerNum:" + producerNum);
        System.out.println("comsumerNum:" + comsumerNum);

        for (int i = 0; i < producerNum; i++) {
            new Thread(new ProducerRunner(queue)).start();
        }
        for (int i = 0; i < comsumerNum; i++) {
            new Thread(new ComsumerRunner((queue))).start();
        }
    }
}

class Queue {
    private List<String> queue = new ArrayList<String>();

    public void add(String string) {
        queue.add(string);
    }

    public void remove() {
        queue.remove(0);
    }

    public int size() {
        return queue.size();
    }
}

class ProducerRunner implements Runnable {
    private Queue queue;
    public ProducerRunner(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            rest();
            synchronized (queue) {
                if (queue.size()<10) {
                    queue.add("test");
                    System.out.println("ProducerRunner:" + queue.size());
                } else {
                    queue.notifyAll();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void rest() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ComsumerRunner implements Runnable {
    private Queue queue;
    public ComsumerRunner(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            rest();
            synchronized (queue) {
                if(queue.size()>0) {
                    queue.remove();
                    System.out.println("ComsumerRunner:" + queue.size());
                } else {
                    queue.notifyAll();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void rest() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}