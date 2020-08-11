package demo.factory.statics;

import demo.factory.Sender;

public class StaticTest {
    public static void main(String[] args) {
        StaticFactory factory = new StaticFactory();
        Sender emailSender = factory.getEmailSender();
        emailSender.send("小静说他想和胖虎生猴子");
    }
}
