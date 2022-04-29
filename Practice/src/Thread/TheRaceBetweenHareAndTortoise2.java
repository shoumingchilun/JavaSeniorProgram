package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-10:49
 */
public class TheRaceBetweenHareAndTortoise2 {
    public static void main(String[] args) {
        TortoiseRun2 t = new TortoiseRun2();
        Rabbit2 r = new Rabbit2();
        t.setPriority(10);
        t.start();
        r.start();
    }
}

class TortoiseRun2 extends Thread {
    int total = 100;

    @Override
    public void run() {
        int i;
        for (i = 0; i < total; i+=10) {
            System.out.println("tortoise has ran "+i+"meters.");
//            try {
//                Thread.sleep(400);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        if(i==total){
            System.out.println("tortoise finished.");
        }
    }
}

class Rabbit2 extends Thread {
    int total = 100;

    @Override
    public void run() {
        int i;
        for (i = 0; i < total; i+=10) {
            System.out.println("Rabbit has ran "+i+"meters.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(i==total){
            System.out.println("Rabbit finished.");
        }
    }
}