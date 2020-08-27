package demo.project.export.mapper;

import demo.project.export.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category")
    List<Category> selectAll();
}
