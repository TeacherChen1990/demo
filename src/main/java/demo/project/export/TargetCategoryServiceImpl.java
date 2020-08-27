package demo.project.export;

import demo.project.export.entity.TargetCategory;
import demo.project.export.mapper.TargetCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetCategoryServiceImpl implements TargetCategoryService {

    @Autowired
    private TargetCategoryMapper targetCategoryMapper;
    @Override
    public int insert(TargetCategory targetCategory) {
        targetCategoryMapper.insert(targetCategory);
        return 0;
    }

    @Override
    public int insertBatch(List<TargetCategory> list) {
        return targetCategoryMapper.insertBatch(list);
    }
}
