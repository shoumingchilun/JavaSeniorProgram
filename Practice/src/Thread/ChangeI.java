package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-12:12
 */
public class ChangeI {
    public static int i = 0;

    public static void main(String[] args) {
        Add add = new Add();
        Minus minus = new Minus();
        Thread ad = new Thread(add);
        Thread mi = new Thread(minus);
        ad.start();
        mi.start();
    }
}

class Add implements Runnable {

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            synchronized (ChangeI.class) {
                System.out.println("add:"+ ++ChangeI.i);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Minus implements Runnable {

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            synchronized (ChangeI.class) {
                System.out.println("minus:"+ --ChangeI.i);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}