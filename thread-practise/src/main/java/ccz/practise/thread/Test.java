package ccz.practise.thread;

/**
 * Created by 46043 on 2017/7/10.
 */
public class Test {
    public static void main(String[] args) {
        Object aLock = new Object();
        Object bLock = new Object();
        Object cLock = new Object();

        synchronized (aLock) {
            System.out.println("a lock");
            synchronized (bLock) {
                System.out.println("b lock");
                synchronized (cLock) {
                    System.out.println("c lock");
                }
            }
        }
    }
}
