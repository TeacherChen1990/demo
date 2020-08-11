package demo.factory.simple;

import demo.factory.EmailSender;
import demo.factory.PhoneSender;
import demo.factory.Sender;

/**
 * 简单工厂模式
 *
 * 通过传入与
 */
public class SimpleFactory implements Factoty{

    @Override
    public Sender getSender(String senderCode) {
        switch (senderCode){
            case "email":
                return new EmailSender();
            case "phone":
                return new PhoneSender();
        }
        return null;
    }
}
