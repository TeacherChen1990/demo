package demo.pattren.proxy.statics;

//销售代理
public class SellProxy implements SellHouse{
    //通过注入被代理对象实现代理功能
    private SellHouse sellHouse;
    public SellProxy(SellHouse sellHouse){
        this.sellHouse = sellHouse;
    }
    @Override
    public void sell() {
        before();
        //买掉房子
        sellHouse.sell();
        after();
    }
    //前置增强
    private void before(){
        System.out.println("新代理房屋销售");
        System.out.println("我先来做一下宣传");
        System.out.println("根据实际情况合房主沟通调整一下售价");
    }
    //后置增强
    private void after(){
        System.out.println("房子卖掉了，我提取佣金");
    }
}
