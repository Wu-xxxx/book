package cn.edu.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Bk implements Serializable {
//    教材Id
    private Integer bkId;

//    使用该教材教师Id 外键链接user表
    private Integer tId;


// 使用该教材教师name
    private String tName;

//    教材名称
    private String bkName;

//    教材作者
    private String bkAuthor;

//    教材入库数量
    private Integer bkNum;

//    教材当前数量
    private Integer bkNumNow;

//    使用该教材班级
    private String bkClassName;

//   外键链接user表
    private User user;

}
