package demo.pattren.factory;

/**
 * WeChat消息发送器
 */
public class WeChatSender implements Sender{

    @Override
    public void send(String msg) {
        System.out.println("使用WeChat发送消息：" + msg);
    }
}
