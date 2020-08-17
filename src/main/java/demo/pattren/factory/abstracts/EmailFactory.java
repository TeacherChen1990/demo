package demo.pattren.factory.abstracts;

import demo.pattren.factory.EmailSender;
import demo.pattren.factory.Sender;

/**
 * Email产品工厂，创建EmailSender产品
 */
public class EmailFactory extends AbstractFactory{
    @Override
    public Sender getSender() {
        return new EmailSender();
    }
}
