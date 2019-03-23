/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: UserInfoController
 * Author:   kevin
 * Date:     2018/10/16 10:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.vp.pojo.BookInfo;
import com.vp.service.BookInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author kevin
 * @create 2018/10/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("/BookInfo")
public class BookInfoController {

    @Resource
   private BookInfoService  bookInfoService;
    @RequestMapping("/add.action")
    public String  add(BookInfo bookInfo){
        System.out.println(bookInfo);
        int i = bookInfoService.insert_Book(bookInfo);
        return "forward:/index.jsp";
    }

    @RequestMapping("/update.action")
    public String  update(BookInfo bookInfo){
        System.out.println(bookInfo);
        int i = bookInfoService.updateByBookid(bookInfo);
        return "forward:/index.jsp";
    }



       @RequestMapping("/detail.action")
       public String  detail(String code, ModelMap map){
           BookInfo bookInfo = bookInfoService.queryByID(code);
           map.addAttribute("bookInfo",bookInfo);
           return "forward:/detail.jsp";
       }


    @RequestMapping("/queryUpdate.action")
    public String  toUpdate(String code, ModelMap map){
        BookInfo bookInfo = bookInfoService.queryByID(code);
        map.addAttribute("bookInfo",bookInfo);
        //办法1 单独将时间转为 字符串存到作用域  日期和月份是单位 前面添加0
        Date publishDate = bookInfo.getPublishDate();
        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(publishDate);
        map.addAttribute("publishDate",format);

        return "forward:/update.jsp";
    }


       @ResponseBody
       @RequestMapping("/delete.action")
       public String  delete(String[]bookcode){
           List  parms=    Arrays.asList(bookcode);
           int i = bookInfoService.deleteByBookID(parms);
           System.out.println("删除:"+i+"行记录");
           return "";
       }



    @ResponseBody //ajax访问 不需要跳转页面
    @RequestMapping(path = "/query.action",  method = RequestMethod.POST,produces=("application/json;charset=UTF-8;"))
    public  String  query(  @RequestParam(defaultValue ="1",required = false)Integer pageNo,Integer bookTypeId,String bookName,Integer borrow){
         //1.调用业务逻辑层
        //返回的数据 有集合  当前页码数  总页数
       PageInfo<BookInfo> pageInfo = bookInfoService.queryBook(pageNo, 3, bookTypeId, bookName, borrow);
        //2. 将pageInfo转为 json
        String jsonString = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd");
        System.out.println(jsonString);
        return  jsonString;
    }



}