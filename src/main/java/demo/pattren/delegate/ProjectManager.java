package demo.pattren.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目经理 - 负责分发任务
 */
public class ProjectManager {
    /**
     * 预先存储具体任务对应的worker
     */
    private Map<String, Worker> workers = new HashMap<>();

    public ProjectManager(){
        workers.put("原型",new ProductManager());
        workers.put("架构",new Architect());
        workers.put("开发",new Development());
    }
    public void dispatch(Job job){
        workers.get(job.getJobName()).doJob(job);
    }
}
