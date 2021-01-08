package demo.pattren.proxy.dynamic;

import demo.pattren.proxy.statics.HouseMaster;
import demo.pattren.proxy.statics.SellHouse;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) throws IOException {
        SellHouse sellHouse = new HouseMaster();
        SellHouse proxy  = (SellHouse)Proxy.newProxyInstance(
                SellHouse.class.getClassLoader(),
                new Class[]{SellHouse.class},
                new SellDynamicProxy(sellHouse));
        proxy.sell();

        byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{SellHouse.class});
        FileOutputStream fileOutputStream = new FileOutputStream("D://$Proxy0.class");
        fileOutputStream.write($Proxy0s);
        fileOutputStream.close();
    }
}
