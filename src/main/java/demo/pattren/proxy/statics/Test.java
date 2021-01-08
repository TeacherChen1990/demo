package demo.pattren.proxy.statics;

public class Test {
    public static void main(String[] args) {
        SellHouse house = new SellProxy(new HouseMaster());
        house.sell();
    }
}
