package cn.edu.book.model;

public class Class {
//    班级id
    private Integer clsId;
//    班级编号
    private String clsNum;
//    班级名称
    private String clsName;
//    学院id,作为外键与college表连接
    private String collegeId;
//    班级与学院关联,查询班级返回对应学院
    private College college;



    public Class() {
    }

    public Class(Integer clsId, String clsNum, String clsName, String collegeId) {
        this.clsId = clsId;
        this.clsNum = clsNum;
        this.clsName = clsName;
        this.collegeId = collegeId;
    }

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }

    public String getClsNum() {
        return clsNum;
    }

    public void setClsNum(String clsNum) {
        this.clsNum = clsNum;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }


    @Override
    public String toString() {
        return "Class{" +
                "clsId=" + clsId +
                ", clsNum='" + clsNum + '\'' +
                ", clsName='" + clsName + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", college=" + college +
                '}';
    }
}
