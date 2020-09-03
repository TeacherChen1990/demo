package demo.pattren.delegate;

import java.util.ArrayList;
import java.util.List;
/**
 * 委派模式模拟测试测试
 */
public class DelegateTest {
    public static void main(String[] args) {
        //任务
        List<Job> project = new ArrayList<>();
        Job job1 = new Job();
        Job job2 = new Job();
        Job job3 = new Job();
        job1.setJobName("原型");
        job2.setJobName("架构");
        job3.setJobName("开发");
        project.add(job1);
        project.add(job2);
        project.add(job3);

        ProjectManager manager = new ProjectManager();
        //产品经理委派任务，对老板来说，任务都交给项目经理，并不关心具体谁完成
        project.forEach(item -> manager.dispatch(item));
    }
}
