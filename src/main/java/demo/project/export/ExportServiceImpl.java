package demo.project.export;

import demo.project.export.entity.Category;
import demo.project.export.entity.Source;
import demo.project.export.entity.Target;
import demo.project.export.entity.TargetCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ExportServiceImpl implements ExportService{

    //每次读取的数据条数，默认2000条
    @Value("${export.pageSize:2000}")
    private int  pageSize;

    @Autowired
    private SourceService sourceService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TargetCategoryService targetCategoryService;
    @Autowired
    private TargetService targetService;


    private Map<String, Category> allCategory;
    //日期不要每条记录都创建一个日期对象
    private Date date = new Date();

    @Override
    public void export() {
        allCategory = categoryService.getAllCategory();
        //exportSource();
        exportSourcev2();
    }

    private void exportSource(){
        List<Source> sources;
        //刷新日期， 这里属性作为日期， 其实应该以局部变量当作参数传递会更好，原谅我偷个懒
        date = new Date();
        int pageNum = 1;
        do{
            sources = sourceService.selectList(pageNum++, pageSize);
            System.out.println(sources);
            for (Source source : sources) {
                //数据转换
                Target transfer = transfer(source);
                //插入数据，返回自增长id
                targetService.insert(transfer);
                TargetCategory targetCategory = new TargetCategory();
                Category category = allCategory.get(source.getCategoryName());
                if(category != null){
                    targetCategory.setCategoryId(category.getId());
                }
                targetCategory.setTargetId(transfer.getId());
                //插入分类数据
                targetCategoryService.insert(targetCategory);
            }
        }while(sources.size() > 0);
    }
    private void exportSourcev2(){
        List<Source> sources;
        //刷新日期， 这里属性作为日期， 其实应该以局部变量当作参数传递会更好，原谅我偷个懒
        date = new Date();
        int pageNum = 1;
        Integer startId = 0;
        do{
            sources = sourceService.selectList(pageNum++, pageSize);
            List<Target> sourceList = new ArrayList();
            List<TargetCategory> targetCategoryList = new ArrayList();
            for (Source source : sources) {
                //数据转换
                Target transfer = transfer(source);
                //第一次，取出自增长id，后面就直接计算
                if(startId == 0){
                    //插入数据，返回自增长id
                    targetService.insert(transfer);
                    startId = transfer.getId();
                }else{
                    startId++;
                    sourceList.add(transfer);
                }
                TargetCategory targetCategory = new TargetCategory();
                Category category = allCategory.get(source.getCategoryName());
                if(category != null){
                    targetCategory.setCategoryId(category.getId());
                }
                targetCategory.setTargetId(transfer.getId());
                targetCategoryList.add(targetCategory);
            }
            if(sourceList.size() > 0){
                targetService.insertBatch(sourceList);
            }
            if(targetCategoryList.size() > 0){
                targetCategoryService.insertBatch(targetCategoryList);
            }
        }while(sources.size() > 0);
    }
    private Target transfer(Source source){
        Target target = new Target();
        target.setCreateTime(date);
        target.setUpdateTime(date);
        target.setSC1(source.getC1());
        target.setSC2(source.getC2());
        target.setSourceAddr(source.getAddr());
        target.setSourceName(source.getUsername());
        target.setSourceAge(source.getAge());
        //默认状态为 未确认
        target.setState("0");
        return target;
    }

}
