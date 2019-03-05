package cn.umr.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换器
 * @author UMR丶晨哥
 * @Date 2018/12/8 20:25
 */

public class CustomDateConversion implements Converter<String,Date> {
    /**
     * 自定义参数绑定器
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        //使用SimpleDateFormat   指定要转换的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
//            throw new RuntimeException(e);
            return null;
        }
}
}
