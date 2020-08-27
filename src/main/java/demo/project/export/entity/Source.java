package demo.project.export.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Source {
    private Integer id;
    private String username;
    private Integer age;
    private String addr;
    private String categoryName;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private Date updateTime;
    private Date createTime;


}
