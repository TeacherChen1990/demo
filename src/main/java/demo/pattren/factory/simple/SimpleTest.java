package demo.pattren.factory.simple;

import demo.pattren.factory.Sender;

public class SimpleTest {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Sender email = factory.getSender("email");
        email.send("隔壁老王叫你早点回家吃饭");
    }

}
