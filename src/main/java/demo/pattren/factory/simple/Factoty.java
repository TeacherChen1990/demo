package demo.pattren.factory.simple;

import demo.pattren.factory.Sender;

public interface Factoty {

    /**
     * 获取sender对象
     */
    public Sender getSender(String senderCode);
}
