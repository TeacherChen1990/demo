package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环测试
 */
public class ForDemo {

    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        for(int i:list){
            System.out.println(i);
            if(i == 2){
                list.remove(i);
                list.add(3);
            }
        }
    }
}
