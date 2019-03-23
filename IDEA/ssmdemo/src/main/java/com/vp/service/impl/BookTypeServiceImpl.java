/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: BookTypeServiceImpl
 * Author:   kevin
 * Date:     2018/10/16 15:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.service.impl;

import com.vp.dao.BookTypeMapper;
import com.vp.pojo.BookType;
import com.vp.service.BookInfoService;
import com.vp.service.BookTypeService;
import org.springframework.stereotype.Service;

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
@Service
public class BookTypeServiceImpl implements BookTypeService {
   @Resource
    private BookTypeMapper  bookTypeMapper;

    @Override
    public List<BookType> queryBookType() {
        return bookTypeMapper.queryBookType();
    }
}