package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-12:38
 */
public class BuyTicket {
    public static void main(String[] args) {
        Seller.seller.run();
        Buyer buyer = new Buyer(5);
        Buyer buyer2 = new Buyer(10);
        Buyer buyer3 = new Buyer(20);
        Thread th1 = new Thread(buyer);
        Thread th2 = new Thread(buyer2);
        Thread th3 = new Thread(buyer3);
        th1.start();
        th2.start();
        th3.start();
    }
}

class Seller implements Runnable {
    static Seller seller = new Seller();
    int temp_money = 5;

    @Override
    public void run() {
        System.out.println("seller begin to sell tickets");
    }
}

class Buyer implements Runnable {
    int money;

    public Buyer(int money) {
        this.money = money;
    }

    @Override
    public void run() {
        while (!ask(Seller.seller)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean ask(Seller seller) {
        synchronized (BuyTicket.class) {
            if (money - 5 <= seller.temp_money) {
                seller.temp_money += 5;
                System.out.println(money + " has bought.");
                return true;
            }
            System.out.println(money + " is waiting......");
            return false;
        }
    }
}