package exercise;

/**
 * @auther 齿轮
 * @create 2022-03-04-22:32
 * <p>
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Consumer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1、是否为多线程？
 * 2、是否共享数据？
 * 3、如何解决线程安全？
 * 4、是否涉及到线程通信?
 */
public class Product_Consumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Producer p2 = new Producer(clerk);
        p1.setName("生产者1");
        p2.setName("生产者2");
        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        c1.setName("消费者1");
        c2.setName("消费者2");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}

class Clerk {
    private int productNumber = 0;

    public synchronized void produceProduct() {
        if (productNumber < 20) {
            productNumber++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productNumber + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productNumber>0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productNumber + "个产品");
            productNumber--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品......");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品......");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

