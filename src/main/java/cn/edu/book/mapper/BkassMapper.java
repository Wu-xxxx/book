package cn.edu.book.mapper;

import cn.edu.book.model.Bkass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BkassMapper {

    List<Bkass> getBkass(Bkass bkass);

    List<Bkass> getBkassByuId(Integer uId);

    List<Bkass> getAllBkass();

    void addBkass(Bkass bkass);

    void updateBkass(Bkass Bkass);

    void deleteBkassById(Integer bkId);

    void updateBkassStatus(Integer id);
}
