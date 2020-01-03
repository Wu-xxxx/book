package cn.edu.book.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

//书籍下发情况表
@Getter
@Setter
@ToString
public class Bkass implements Serializable {
//    主键id
    private Integer id;

//    书籍id 外键 和bk主键链接
    private Integer bkId;

    // 教材名称
    private String bkName;

    // 教材名称
    private String bkAuthor;

//     用户id uid 用于辨别下发的人员是谁
//    外键链接的user表
    private  Integer uId;

//    判断书籍下发状态 0-下发但未确认  1-下发并确认
    private Integer status;

//    外键链接的book表
    private Bk bk;

    //    外键链接的user表
    private User user;

}
