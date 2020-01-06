package cn.edu.book.mapper;


import cn.edu.book.model.Bk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BkMapper {

    List<Bk> getBk(Bk bk);

    List<Bk> getBkById(Integer bkId);

    List<Bk> getBkBytId(Integer tId);

    List<Bk> getBkBybkClassName(String bkClassName);


    List<Bk> getAllBk();

    List<Bk> getAllBk2();

    void addBk(Bk bk);

    void updateBk(Bk bk);


    void deleteBkById(Integer bkId);
}
