package cn.edu.book.mapper;


import cn.edu.book.model.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    Class getClassById(Integer clsId);


    List<Class> getClass(Class class1);

    List<Class> getAllClass();

    void addClass(Class class1);

    List<Class> getClassByClgId(Integer collegeId);
    void updateClass(Class class1);

    void deleteClassById(Integer clsId);
}
