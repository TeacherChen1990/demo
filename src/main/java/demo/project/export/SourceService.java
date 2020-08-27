package demo.project.export;

import demo.project.export.entity.Source;

import java.util.List;

/**
 * 数据源操作
 */
public interface SourceService {

    List<Source> selectList(Integer pageNum, Integer pageSize);
}
