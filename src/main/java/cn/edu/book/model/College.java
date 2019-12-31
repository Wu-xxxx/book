package cn.edu.book.model;

public class College {
//学院id
    public Integer clgId;

// 学院编号
    public String clgNum;

//  学院名称
    public String clgName;


    public College() {
    }

    public College(Integer clgId, String clgNum, String clgName) {
        this.clgId = clgId;
        this.clgNum = clgNum;
        this.clgName = clgName;
    }

    public Integer getClgId() {
        return clgId;
    }

    public void setClgId(Integer clgId) {
        this.clgId = clgId;
    }

    public String getClgNum() {
        return clgNum;
    }

    public void setClgNum(String clgNum) {
        this.clgNum = clgNum;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }


    @Override
    public String toString() {
        return "College{" +
                "clgId=" + clgId +
                ", clgNum='" + clgNum + '\'' +
                ", clgName='" + clgName + '\'' +
                '}';
    }
}
