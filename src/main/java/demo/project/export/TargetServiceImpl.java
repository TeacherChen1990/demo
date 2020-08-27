package demo.project.export;

import demo.project.export.entity.Target;
import demo.project.export.mapper.TargetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private TargetMapper targetMapper;

    @Override
    public int insert(Target target) {
        return targetMapper.insert(target);
    }

    @Override
    public int insertBatch(List<Target> list) {
        return targetMapper.insertBatch(list);
    }


}
