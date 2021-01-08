package demo.pattren.proxy.statics;

//房屋主人
public class HouseMaster implements SellHouse {
    @Override
    public void sell() {
        System.out.println("我是房屋的主人，我买掉房子");
    }
}
