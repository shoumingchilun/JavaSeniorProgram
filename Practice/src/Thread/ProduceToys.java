package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-10:20
 */
public class ProduceToys {
    public static void main(String[] args) {
        Thread thread = new Thread(new produce());
        thread.start();
    }
}

class produce implements Runnable {
    int total = 1;
    static Thread eat = new Thread(new eating());
    @Override
    public void run() {
        for (; total <= 50; total++) {
            System.out.println("product the " + total + "th toy");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (total == 20) {
                eat.start();
                try {
                    eat.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class eating implements Runnable {
    int total = 1;

    @Override
    public void run() {
        for (; total <= 3; total++) {
            System.out.println("eat the " + total + "th steamed bun");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}