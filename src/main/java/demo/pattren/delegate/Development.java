package demo.pattren.delegate;

/**
 * 开发
 */
public class Development implements Worker {
    @Override
    public void doJob(String job) {
        System.out.println("开发人员黑着眼圈，并完成" + job);
        System.out.println("开发人员向你抛出异常，项目延期");
        System.out.println("加班加点，开发人员完成工作");
    }
}
