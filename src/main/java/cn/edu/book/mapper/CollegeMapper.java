package cn.edu.book.mapper;

import cn.edu.book.model.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Wu on 2019/12/31.
 */
@Mapper
public interface CollegeMapper {
  List<College> getAllCollege();
}
