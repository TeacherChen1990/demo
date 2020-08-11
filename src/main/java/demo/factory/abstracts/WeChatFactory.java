package demo.factory.abstracts;

import demo.factory.Sender;
import demo.factory.WeChatSender;

/**
 * WeChat产品创建工厂
 */
public class WeChatFactory extends AbstractFactory{
    @Override
    public Sender getSender() {
        return new WeChatSender();
    }
}
