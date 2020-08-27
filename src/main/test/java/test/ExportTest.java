package test;

import demo.DemoApplication;
import demo.project.export.ExportService;
import demo.project.export.SourceService;
import demo.project.export.entity.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ExportTest {
    @Autowired
    private ExportService exportService;

    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        exportService.export();
        long l1 = System.currentTimeMillis();
        System.out.println("执行耗时:" + (l1-l) + "ms");
    }
}
