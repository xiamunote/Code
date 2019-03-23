/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: DateConverter
 * Author:   kevin
 * Date:     2018/10/15 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.vp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author kevin
 * @create 2018/10/15
 * @since 1.0.0
 */
public class DateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
          simpleDateFormat.setLenient(false);

          if (s!=null){
              try {
                return   simpleDateFormat.parse(s);
              } catch (ParseException e) {
                  e.printStackTrace();
              }

          }
          return  null;

    }
}