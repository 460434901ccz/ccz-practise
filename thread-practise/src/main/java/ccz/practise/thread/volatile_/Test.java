package ccz.practise.thread.volatile_;

/**
 * Created by 46043 on 2017/7/10.
 */
public class Test {
    private volatile static Integer integer = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (integer) {
                        System.out.println("increament thread:" + integer++);
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(3000L);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("non change thread:" + integer);
                    try {
                        synchronized (integer) {
                            Thread.sleep(100L);
                        }
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
