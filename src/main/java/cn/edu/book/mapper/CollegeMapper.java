package cn.edu.book.mapper;

import cn.edu.book.model.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeMapper {

    College getCollegeById(Integer clgId);

    List<College> getAllCollege();

    void addCollege(College college);


    void updateCollege(College college);

    void deleteCollegeById(Integer clgId);
}
