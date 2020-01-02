package cn.edu.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Course implements Serializable {
//    课程id
    private Integer courseId;

//    课程编号
    private String courseNum;

//    课程名称
    private String courseName;

//    班级id与班级外键连接，查询班级可显示（父表）对应班级中的信息
//    每个班级中的课程都相同
    private Integer classId;

//    存储班级信息
    private Class aClass;

//    存储学院信息
    private College college;

}
