package exercise;

/**
 * @auther 齿轮
 * @create 2022-03-04-21:18
 * <p>
 * 两个储户向同一个账户存款3000元，每次1000，存3次，存完打印账户余额
 * <p>
 * 分析：
 * 1、是否为多线程问题？
 * 2、是否有共享数据？
 * 3、是否有线程安全问题？
 * 4、如何解决线程安全问题？
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();

    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {
        synchronized (this){
            if (amt > 0) {
                balance += amt;
                System.out.println(Thread.currentThread().getName()+"存钱成功。余额为：" + balance);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Customer extends Thread {

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }

    }
}