package demo.pattren.factory.abstracts;

import demo.pattren.factory.PhoneSender;
import demo.pattren.factory.Sender;

/**
 * Phone产品工厂，创建PhoneSender产品
 */
public class PhoneFactory extends AbstractFactory{
    @Override
    public Sender getSender() {
        return new PhoneSender();
    }
}
