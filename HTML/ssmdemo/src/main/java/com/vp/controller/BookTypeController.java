/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: BookTypeController
 * Author:   kevin
 * Date:     2018/10/16 15:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.controller;

import com.alibaba.fastjson.JSON;
import com.vp.pojo.BookType;
import com.vp.service.BookTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉  resultful
 *
 * @author kevin
 * @create 2018/10/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("/BookType")
//@SessionAttributes({"bookTypes"})
public class BookTypeController {

    @Resource
    private BookTypeService bookTypeService;

    @ResponseBody
    @RequestMapping( path = "/query.action",produces =("application/json;charset=UTF-8;"))
    public String queryBookType(ModelMap map) {
        List<BookType> bookTypes = bookTypeService.queryBookType();
      //  map.addAttribute("bookTypes",bookTypes);
        String jsonString = JSON.toJSONString(bookTypes);
        return jsonString;
    }


}