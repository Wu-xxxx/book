package cn.edu.book.mapper;

import cn.edu.book.model.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Wu on 2019/12/31.
 */
@Mapper
public interface CollegeMapper {
  College getCollegeById(Integer clgId);

  List<College> getCollege(College college);

  List<College> getAllCollege();

  void addCollege(College college);


  void updateCollege(College college);

  void deleteCollegeById(Integer clgId);
}
