package cn.edu.book.mapper;


import cn.edu.book.model.Bk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BkMapper {

    List<Bk> getBk(Bk bk);

    List<Bk> getAllBk();

    void addBk(Bk bk);

    void updateBk(Bk bk);

    void deleteBkById(Integer bkId);
}
