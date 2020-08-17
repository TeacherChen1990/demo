package demo.pattren.factory;

/**
 * 邮件发送器
 */
public class EmailSender implements Sender{

    @Override
    public void send(String msg) {
        System.out.println("通过EmailSender发送:" + msg);
    }
}
