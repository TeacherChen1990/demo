package datacreater;



import java.io.*;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName Insert
 * @Description https://github.com/JavaFish9527/demo
 * @Author chenl
 * @Date 2020/12/25 13:46
 * @Version 1.0
 **/
public class Insert {
    //随机的姓
    private static final String[] NAME_RAN = {"王","李","张","陈","马","刘","皇甫","诺兰"};
    //随机的city
    private static final String[] COMPANY_RAN = {"重庆市","成都市","四川省","南充市","北京市"};
    //随机邮件
    private static final String[] EMAIL_RAN = {"qq","163","fbank","139"};
    //随机状态
    private static final int[] GENDER_RAN = {1,0};
    private static Random ran = new Random();
    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        writeData(50000000);
        long l1 = System.currentTimeMillis();
        System.out.println("写入数据完成,耗时:" + (l1-l)/1000 + "s");
//        System.out.println(l);
    }

    /**
     * 测试使用写入文件 + load语法载入5000万数据耗时8分半(可能受机器配置影响)
     * MySQL高效的数据加载语法 LOAD DATA LOCAL INFILE 'D://data.txt' INTO TABLE emp (age,email,user_name,status,sex,salary。。。。。);
     *
     * 数据写入ES 使用Datax工具进行处理
     *
     * @param count the data total
     * @throws IOException
     */
    private static void writeData(int count) throws IOException {
        String filePath = "E://data1.txt";
        //分隔符
        String sp = "\t";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        for(int i=0;i<count;i++){
            if(i%1000==0)
                System.out.println(i);
            long l = System.currentTimeMillis();
            String l1 = l + "";
            //字段数据
            Integer var1 = ran.nextInt(100);
            String var2 = randomEmail();
            String var4 = randomName();
            Integer var5 = ran.nextInt(2);
            int var6 = GENDER_RAN[ran.nextInt(GENDER_RAN.length)];
            double var7 = Double.parseDouble(ran.nextInt(10000) + 5000 + "");
            //格式化日期
            String var8 = DateUtil.formatDateTime(new Date());
            StringBuilder builder = new StringBuilder();
            //拼接
            builder.append(var1).append(sp);
            builder.append(var2).append(sp);
            builder.append(var4).append(sp);
            builder.append(var5).append(sp);
            builder.append(var6).append(sp);
            builder.append(var7).append(sp);
            builder.append(var8).append(sp);

            //添加冗余数据，已更好的测试性能
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany()).append(sp);
            builder.append(randomCompany());

            bw.write(builder.toString());
            bw.newLine();
        }
        bw.close();
    }
    private static String randomStr(int c) throws UnsupportedEncodingException {
        StringBuilder name = new StringBuilder();
        for(int i=0;i<c;i++){
            int h = 176 + ran.nextInt(39);
            int l = 161 + ran.nextInt(93);
            byte[] bytes = new byte[2];
            bytes[0] = (byte)h;
            bytes[1] = (byte)l;
            name.append(new String(bytes, "gbk"));
        }
        return name.toString();
    }

    /**
     * 随机姓名
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String randomName() throws UnsupportedEncodingException {
        return NAME_RAN[ran.nextInt(NAME_RAN.length)] + randomStr(ran.nextInt(2) + 1);
    }
    private static String randomCompany() throws UnsupportedEncodingException {
        return COMPANY_RAN[ran.nextInt(COMPANY_RAN.length)] + randomStr(ran.nextInt(10) + 1) + "有限公司";
    }

    /**
     * 邮件随机
     * @return
     */
    private static String randomEmail(){
        return randomNumber(ran.nextInt(3) + 8) + "@" + EMAIL_RAN[ran.nextInt(EMAIL_RAN.length)] + ".com";
    }

    /**
     * 数字随机
     * @param len 指定长度
     * @return 纯数字字符串
     */
    private static String randomNumber(int len){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<len;i++){
            builder.append(ran.nextInt(10));
        }
        return builder.toString();
    }
}