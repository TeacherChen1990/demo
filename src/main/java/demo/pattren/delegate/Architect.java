package demo.pattren.delegate;

/**
 * 架构师
 */
public class Architect implements Worker {

    @Override
    public void doJob(Job job) {
        System.out.println("架构师正摸着脑袋，完成" + job.getJobName());
        System.out.println("架构师完成工作");
    }
}
