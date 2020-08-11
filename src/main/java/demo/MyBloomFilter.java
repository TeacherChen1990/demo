package demo;

import java.util.BitSet;

/**
 * Bloomg过滤器
 */
public class MyBloomFilter {
    /**
     * 位的大小
     */
    private static final int DEFAILT_BIT_SIZE = 2 << 24;

    /**
     * 多种过滤器
     */
    private static final int[] SEEDS = new int[]{3,13,46,71,91,134};

    /**
     * JDK提供的位数组
     */
    private BitSet bits = new BitSet(DEFAILT_BIT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter() {
        for(int i=0;i<SEEDS.length;i++){
            func[i] = new SimpleHash(DEFAILT_BIT_SIZE,SEEDS[i]);
        }
    }

    /**
     * 放入元素， 标记位数组指定的位为true，表示次数已存入过
     * @param value
     */
    public void add(Object value){
        for (SimpleHash simpleHash : func) {
            bits.set(simpleHash.hash(value),true);
        }
    }

    public boolean constains(Object value){
        boolean ret = true;
        for(SimpleHash simpleHash : func){
            ret = ret && bits.get(simpleHash.hash(value));
        }
        return ret;
    }


    /**
     * 用于Hash计算
     */
    public static class SimpleHash{

        private int cap;

        private int seed;

        private SimpleHash() {

        }

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value){
            int h;
            return (value == null) ? 0 : Math.abs((seed * (cap - 1)  & (h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public static void main(String[] args) {
        String value1 = "abcd";
        String value2 = "dbca";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.constains(value1));
        System.out.println(filter.constains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.constains(value1));
        System.out.println(filter.constains(value2));

        Integer v1 = 123;
        Integer v2 = 321;
        System.out.println(filter.constains(v1));
        System.out.println(filter.constains(v2));
        filter.add(v1);
        filter.add(v2);
        System.out.println(filter.constains(v1));
        System.out.println(filter.constains(v2));
    }
}
