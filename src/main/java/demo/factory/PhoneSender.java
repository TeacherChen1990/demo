package demo.factory;

/**
 * 手机短信发送器
 */
public class PhoneSender implements Sender{

    @Override
    public void send(String msg) {
        System.out.println("通过PhoneSender发送:" + msg);
    }
}
