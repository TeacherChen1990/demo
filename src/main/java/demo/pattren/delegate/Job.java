package demo.pattren.delegate;

import lombok.Builder;
import lombok.Data;

/**
 * 任务
 */
@Data
public class Job {
    //实际开发中的任务类肯定比较复杂，属性非常多
    private String jobName;
}
