package ccz.practise.thread.executor;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 46043 on 2017/6/28.
 */
public class InterruptPractise {
    public static void main(String[] args) throws InterruptedException, IOException {
        Thread t = new Thread(new R());
        t.start();
        Thread.sleep(2000L);
        t.interrupt();
    }

    static class R implements Runnable {

        public void run() {
            while(true) {
                System.out.println("while");
                if(Thread.currentThread().isInterrupted()) break;
            }
            System.out.println("break");
        }
    }
}
