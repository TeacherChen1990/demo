package demo.project.export.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Target {
    private Integer id;
    private String sourceName;
    private Integer sourceAge;
    private String sourceAddr;
    private String sC1;
    private String sC2;
    private String state;
    private Date createTime;
    private Date updateTime;
}
