package com.zorbit.platform.core.utils;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;


public class BeanUtils {
    private static BeanUtilsBean beanUtils;
    
    private BeanUtils() {
        ConvertUtilsBean convertUtils = new ConvertUtilsBean();

        DateConverter dateConverter = new DateConverter();

        convertUtils.register(dateConverter,Date.class);
        
        //因为要注册converter,所以不能再使用BeanUtils的静态方法了，必须创建BeanUtilsBean实例
    
        beanUtils = new BeanUtilsBean(convertUtils,new PropertyUtilsBean());
    }

    public static BeanUtilsBean getBeanUtils(){
        if(beanUtils==null){
            new BeanUtils();
        }
        return beanUtils;
    }
}
