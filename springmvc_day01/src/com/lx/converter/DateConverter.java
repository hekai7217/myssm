package com.lx.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * create by hekai  2019-06-24
 *
 * @desc
 *
 *    S:需要 转换的 源
 *    T:target
 *
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
