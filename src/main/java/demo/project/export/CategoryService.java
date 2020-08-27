package demo.project.export;

import demo.project.export.entity.Category;

import java.util.Map;

public interface CategoryService {

    /**
     * 获取所有的分类，以分类name作为key 对应的对象作为value
     * @return
     */
    Map<String, Category> getAllCategory();
}
