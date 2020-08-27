package demo.aqs;

public class Money {
    /**
     * 假设现在账户有1000块钱
     */
    private volatile int money = 1000;
    //private int money = 1000;
    /**
     * 取钱
     */
    public void drawMoney(){
        this.money--;
    }
    public static void main(String[] args) throws InterruptedException {
        Money money = new Money();
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
