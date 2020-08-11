package demo.factory.abstracts;

import demo.factory.PhoneSender;
import demo.factory.Sender;

/**
 * Phone产品工厂，创建PhoneSender产品
 */
public class PhoneFactory extends AbstractFactory{
    @Override
    public Sender getSender() {
        return new PhoneSender();
    }
}
