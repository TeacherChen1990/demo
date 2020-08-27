package demo.project.export;

import demo.project.export.entity.Target;

import java.util.List;

public interface TargetService {
    int insert(Target target);

    int insertBatch(List<Target> list);
}
