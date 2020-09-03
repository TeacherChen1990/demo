package demo.pattren.delegate;

/**
 * 产品经理
 */
public class ProductManager implements Worker{


    @Override
    public void doJob(Job job) {
        System.out.println("产品经理正喝着下午茶，并完成" + job.getJobName());
        System.out.println("产品经理完成工作");
    }
}
