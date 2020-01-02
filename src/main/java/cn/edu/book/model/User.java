package cn.edu.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Wu on 2020/1/2.
 */
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String uId;
    private String name;
    private String gender;
    private String role;
    private String collegeName;
    private String className;
    private String password;
}

