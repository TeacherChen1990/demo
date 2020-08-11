package demo.factory.abstracts;

import demo.factory.EmailSender;
import demo.factory.Sender;

/**
 * Email产品工厂，创建EmailSender产品
 */
public class EmailFactory extends AbstractFactory{
    @Override
    public Sender getSender() {
        return new EmailSender();
    }
}
