package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-10:11
 */
public class Output50withinOddAndEven {
    public static void main(String[] args) {
        myThread m1 = new myThread();
        myThread m2 = new myThread();
        m1.k = 0;
        m2.k = 1;
        m1.start();
        m2.start();
    }
}

class myThread extends Thread {
    public int k = 0;

    public void run() {
        while ((k+=2) <= 50) {
            System.out.println(Thread.currentThread().getName()+"\t"+k);
        }
    }
}