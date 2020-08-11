package demo.factory.statics;

import demo.factory.EmailSender;
import demo.factory.PhoneSender;
import demo.factory.Sender;

/**
 * 静态方法工厂模式
 */
public class StaticFactory {
    //Email生产方法
    public Sender getEmailSender(){
        return new EmailSender();
    }
    //Phone生产方法
    public Sender getPhoneSender(){
        return new PhoneSender();
    }
}
