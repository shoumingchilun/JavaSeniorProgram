package SafeWindowTest;

/**
 * @auther 齿轮
 * @create 2022-03-04-14:38
 *
 * 使用同步方法解决Thread继承类多线程的线程安全问题
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    private static synchronized void show(){//同步监视器为Window4.class
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket--);
        }
    }
    @Override
    public void run() {
        while (ticket>0) {
            show();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}