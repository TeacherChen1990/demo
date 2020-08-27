package demo.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMoney {
    Lock lock = new ReentrantLock();
    /**
     * 假设现在账户有1000块钱
     */
    private int money = 1000;
    //private int money = 1000;
    /**
     * 取钱
     */
    public void drawMoney(){
        lock.lock();
        this.money--;
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        LockMoney money = new LockMoney();
        for(int i=0; i<1000; i++){
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money.drawMoney();
            },i + "").start();
        }
        Thread.sleep(2000);
        System.out.println("当前账户余额：" + money.money);
    }
}
