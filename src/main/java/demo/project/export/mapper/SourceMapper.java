package demo.project.export.mapper;

import demo.project.export.entity.Source;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SourceMapper {

//    @Select("SELECT * FROM source")
//    List<Source> selectList();

    /**
     * 查询优化
     * @return
     */
//    @Select(" SELECT  t.* " +
//            " FROM    ( " +
//            "        SELECT  id " +
//            "        FROM    source " +
//            "        ORDER BY " +
//            "                id " +
//            "        LIMIT #{offset}, #{size} " +
//            "        ) q " +
//            "JOIN    source t " +
//            "ON      t.id = q.id")
//    List<Source> selectList(PageParam page);

    @Select(" SELECT  t.* " +
            " FROM    ( " +
            "        SELECT  id " +
            "        FROM    source " +
            "        ORDER BY " +
            "                id " +
            "        LIMIT #{offset}, #{size} " +
            "        ) q " +
            "JOIN    source t " +
            "ON      t.id = q.id")
    List<Source> selectList(PageParam page);
}
