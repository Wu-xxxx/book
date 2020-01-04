package cn.edu.book.mapper;

import cn.edu.book.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Wu on 2020/1/2.
 */
@Mapper
public interface UserMapper {
    List<User> listAll();
    List<User>listSelected(@Param("uId")String uId,@Param("name")String name,@Param("className")String className,@Param("collegeName")String collegeName);
    User findByName(String name);
    void delete(Integer id);
    void save(User user);
    void update(User user);
}
