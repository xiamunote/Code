/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: ImageUpload
 * Author:   kevin
 * Date:     2018/10/16 16:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author kevin
 * @create 2018/10/16
 * @since 1.0.0
 */
@Controller
public class ImageUpload implements ServletContextAware {
    private ServletContext servletContext;
    @Override
    public void setServletContext(javax.servlet.ServletContext servletContext) {
        this.servletContext=servletContext;
    }


    @RequestMapping(path = "/uploadImage.action",produces ="application/json;charset=UTF-8;")
    @ResponseBody
    public   String imageUpload(@RequestParam("fileImage")CommonsMultipartFile fileImage){
        //1.获取上传文件的绝对路径
        String realPath = servletContext.getRealPath("/upload/");
        System.out.println("上传的路径:"+realPath);
        //2.获取上传文件的名字
        String imageName = fileImage.getOriginalFilename();
        //3.创建io流  file
        File file=new File(realPath,imageName);
        //4.写入到指定的位置
        try {
            fileImage.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //5.将文件的路径以json方式返回给客户端
        String name= "/upload/"+imageName;
        String jsonString = JSON.toJSONString(name);
        System.out.println(jsonString);
        return  jsonString;
    }


}