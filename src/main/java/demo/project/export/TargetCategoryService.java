package demo.project.export;

import demo.project.export.entity.TargetCategory;

import java.util.List;

public interface TargetCategoryService {

    int insert(TargetCategory targetCategory);


    int insertBatch(List<TargetCategory> list);
}
