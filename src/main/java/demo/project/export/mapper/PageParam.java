package demo.project.export.mapper;

import lombok.Data;

@Data
public class PageParam {
    //偏移量
    private Integer offset;
    //查询数量
    private Integer size;
}
