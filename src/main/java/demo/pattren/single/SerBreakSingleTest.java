package demo.pattren.single;

import java.io.*;

/**
 * 序列化破坏单例测试
 */
public class SerBreakSingleTest {

    public static void main(String[] args) throws Exception {
        //正常的方式获取单例对象
        InnerSingle instance = InnerSingle.getInstance();

        //写入磁盘
        FileOutputStream fos = new FileOutputStream("d:/single");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance);
        oos.close();
        fos.close();

        //从磁盘读取对象
        FileInputStream fis = new FileInputStream("d:/single");
        ObjectInputStream ois = new ObjectInputStream(fis);
        InnerSingle innerSingle = (InnerSingle) ois.readObject();

        System.out.println(instance);
        System.out.println(innerSingle);
        System.out.println(innerSingle == instance);
    }
}
