package demo.project.export;

import demo.project.export.entity.Category;
import demo.project.export.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @PostConstruct
    private void init(){

    }

    @Override
    public Map<String, Category> getAllCategory() {
        Map<String, Category> allCategory = new HashMap<>();
        categoryMapper.selectAll().forEach(item -> {
            //名称是唯一的
            allCategory.put(item.getCategoryName(),item);
        });
        return allCategory;
    }
}
