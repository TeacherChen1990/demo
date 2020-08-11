package demo;

public class IntegerCacheDemo {

    public static void main(String[] args) {
        compare(1,1);
        compare(127,127);
        compare(128,128);

        compareWithEquals(1,1);
        compareWithEquals(127,127);
        compareWithEquals(128,128);



    }

    /**
     * 错误的包装类比较
     * @param a
     * @param b
     */
    public static void compare(Integer a, Integer b){
        System.out.println(a == b ? a + " == " + b:a + " != " + b);
    }
    /**
     * 正确的的包装类比较
     * @param a
     * @param b
     */
    public static void compareWithEquals(Integer a, Integer b){
        System.out.println(a.equals(b) ? a + " == " + b:a + " != " + b);
    }
}
