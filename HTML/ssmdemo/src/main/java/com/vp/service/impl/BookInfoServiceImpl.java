/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: UserInfoServiceImpl
 * Author:   kevin
 * Date:     2018/10/16 10:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vp.dao.BookInfoMapper;
import com.vp.pojo.BookInfo;
import com.vp.service.BookInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author kevin
 * @create 2018/10/16
 * @since 1.0.0
 */
@Transactional
@Service
public class BookInfoServiceImpl  implements BookInfoService {

   @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public  PageInfo<BookInfo> queryBook(Integer pageNum, Integer pageSize, Integer bookTypeid, String bookname, Integer borrow) {
        PageHelper.startPage(pageNum,pageSize);
        List<BookInfo> bookInfoList = bookInfoMapper.queryBook(bookTypeid, bookname, borrow);
        PageInfo<BookInfo> pageInfo=new PageInfo<>(bookInfoList);
        return pageInfo;
    }

    @Override
    public int insert_Book(BookInfo bookInfo) {
        return bookInfoMapper.insert(bookInfo);
    }

    @Override
    public int deleteByBookID(List ids) {
        return bookInfoMapper.deleteByBookID(ids);
    }

    @Override
    public int updateByBookid(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    public BookInfo queryByID(String id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }
}