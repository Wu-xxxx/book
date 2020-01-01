package cn.edu.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

@Getter@Setter@ToString
public class Class implements Serializable {
    //    班级id
    private Integer clsId;
    //班级编号
    private String clsNum;
    //班级名称
    private String clsName;
    //学院id,作为外键与college表连接
    private int collegeId;
    //班级与学院关联,查询班级返回对应学院
    private College college;


}
