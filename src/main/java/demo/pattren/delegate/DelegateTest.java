package demo.pattren.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 委派模式测试：
 */
public class DelegateTest {

    public static void main(String[] args) {
        //任务
        List<String> project = new ArrayList<>();
        project.add("原型");
        project.add("架构");
        project.add("开发");

        ProjectManager manager = new ProjectManager();
        //产品经理委派任务，对老板来说，任务都交给项目经理，并不关心具体谁完成
        project.forEach(item -> manager.dispatch(item));
        LockSupport.park();
    }
}
