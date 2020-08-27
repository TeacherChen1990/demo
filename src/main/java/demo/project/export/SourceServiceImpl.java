package demo.project.export;

import demo.project.export.entity.Source;
import demo.project.export.mapper.PageParam;
import demo.project.export.mapper.SourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements SourceService{
    @Autowired
    private SourceMapper sourceMapper;
//    @Override
//    public List<Source> selectList(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<Source> sources = sourceMapper.selectList();
//        return sources;
//    }

    //优化查询
    @Override
    public List<Source> selectList(Integer pageNum, Integer pageSize) {
        PageParam pageParam = new PageParam();
        Integer offset = (pageNum - 1) * pageSize;
        pageParam.setOffset(offset);
        pageParam.setSize(pageSize);
        List<Source> sources = sourceMapper.selectList(pageParam);
        return sources;
    }
}
