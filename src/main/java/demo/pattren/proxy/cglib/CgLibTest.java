package demo.pattren.proxy.cglib;

import demo.pattren.proxy.statics.HouseMaster;

public class CgLibTest {
    public static void main(String[] args) {
        HouseMaster sellHouse = new HouseMaster();
        CgLibProxy cgLibProxy = new CgLibProxy();
        HouseMaster h = (HouseMaster)cgLibProxy.getInstance(sellHouse);
        h.sell();
    }
}
