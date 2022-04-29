package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-16:08
 * <p>
 * 编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，生产10台电视机，一边生产一边销售（消费）。
 */
public class TVProducersAndConsumers {
    public static void main(String[] args) {
        clerk clerk1 = new clerk();
        Producer p1 = new Producer(clerk1);
        Consumer c1 = new Consumer(clerk1);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        t1.start();
        t2.start();
    }
}

class clerk {
    int inventory = 0;
    int count = 0;

    public synchronized void product() {
        notify();
        System.out.println("生产第" + ++count + "个");
        inventory++;
        if (inventory == 4) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        notify();
    }

    public synchronized void consume() {
        notify();
        if (inventory != 0) {
            System.out.println("消费库存中第" + inventory-- + "个");
        }
//        inventory--;
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    private clerk clerk1;

    public Producer(clerk clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {

        while (clerk1.count < 10) {
            clerk1.product();
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("生产结束");
    }
}

class Consumer implements Runnable {
    private clerk clerk1;

    public Consumer(clerk clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {
        while (true) {
            clerk1.consume();
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (clerk1.count == 10 && clerk1.inventory == 0) {
                System.out.println("消费结束");
                break;
            }
        }
    }
}
