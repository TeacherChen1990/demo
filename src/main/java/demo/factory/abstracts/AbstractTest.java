package demo.factory.abstracts;

import demo.factory.Sender;

public class AbstractTest {
    public static void main(String[] args) {
        AbstractFactory factory = new EmailFactory();
        Sender sender = factory.getSender();
        sender.send("老王受到了巨龙撞击，血量80%");

        AbstractFactory factory1 = new PhoneFactory();
        Sender sender1 = factory1.getSender();
        sender1.send("老王受到了致命打击，血量50%");

        AbstractFactory factory2 = new WeChatFactory();
        Sender sender2 = factory1.getSender();
        sender2.send("妈妈再也不用担心我不会工厂模式了");
    }
}
