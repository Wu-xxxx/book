package cn.edu.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter@Setter@ToString
public class College implements Serializable {
    //学院id
    public Integer clgId;
    //学院编号
    public String clgNum;
    //学院名称
    public String clgName;

}
