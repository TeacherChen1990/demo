package demo.project.export.mapper;

import demo.project.export.entity.TargetCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TargetCategoryMapper {

    void insert(TargetCategory targetCategory);

    int insertBatch(List<TargetCategory> list);
}
