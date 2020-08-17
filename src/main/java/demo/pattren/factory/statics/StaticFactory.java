package demo.pattren.factory.statics;

import demo.pattren.factory.EmailSender;
import demo.pattren.factory.PhoneSender;
import demo.pattren.factory.Sender;

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
