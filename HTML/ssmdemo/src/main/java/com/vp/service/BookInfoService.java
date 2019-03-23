/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: UserInfoService
 * Author:   kevin
 * Date:     2018/10/16 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.service;

import com.github.pagehelper.PageInfo;
import com.vp.pojo.BookInfo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author kevin
 * @create 2018/10/16
 * @since 1.0.0
 */
public interface BookInfoService {
    /**
     * 带3条件的动态查询
     * @param bookTypeid 类型id
     * @param bookname  图书名称
     * @param borrow  是否借阅  0未借阅 1已借阅
     * @return
     */
    PageInfo<BookInfo> queryBook(Integer pageNum, Integer pageSize, Integer bookTypeid, String  bookname, Integer borrow);
    /**
     * 增
     * @param BookInfo
     * @return
     */
    int insert_Book(BookInfo BookInfo);

    int deleteByBookID(List ids);

    int updateByBookid(BookInfo  BookInfo);

    BookInfo  queryByID(String id);

}