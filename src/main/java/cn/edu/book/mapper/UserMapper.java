package cn.edu.book.mapper;

import cn.edu.book.model.User;
import org.apache.ibatis.annotations.Mapper;



/**
 * Created by Wu on 2020/1/2.
 */
@Mapper
public interface UserMapper {
    User findByName(String name);
}
