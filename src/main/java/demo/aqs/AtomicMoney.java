package demo.aqs;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMoney {
    /**
     * 假设现在账户有1000块钱
     */
    private AtomicInteger money = new AtomicInteger(1000);
    /**
     * 取钱
     */
    public void drawMoney(){
        //AtomicInteger的自减操作
        this.money.getAndDecrement();
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicMoney money = new AtomicMoney();
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
