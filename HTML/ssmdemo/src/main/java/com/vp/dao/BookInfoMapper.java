package com.vp.dao;

import com.vp.pojo.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper {

    List<BookInfo> queryBook(@Param("bookTypeid") Integer bookTypeid, @Param("bookname") String bookname, @Param("borrow") Integer borrow);

    int deleteByBookID(List ids);
    int deleteByPrimaryKey(String bookCode);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(String bookCode);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}