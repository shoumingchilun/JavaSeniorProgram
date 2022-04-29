package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther 齿轮
 * @create 2022-03-04-16:20
 *
 * 解决线程安全的方式三：Lock锁
 * 1.实例化ReentrantLock
 * 2.调用lock()
 * 3.调用unlock()
 *
 * synchronized与Lock异同：
 * 同：都能解决线程同步问题
 * 异：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *         Lock需要手动启同步，结束同步也需要手动实现
 *
 *
 * 使用优先级：Lock->同步代码块->同步方法
 *
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("window1");
        t2.setName("window2");
        t3.setName("window3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "：售票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
