package demo.project.export.mapper;

import demo.project.export.entity.Target;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TargetMapper {

    int insertBatch(List<Target> list);

    int insert(Target target);
}
