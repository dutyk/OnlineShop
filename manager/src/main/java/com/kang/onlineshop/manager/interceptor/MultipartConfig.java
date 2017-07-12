package com.kang.onlineshop.manager.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by yuankang on 2017/7/3.
 */
@Component("multipartResolver")
public class MultipartConfig extends CommonsMultipartResolver{
    public void MultipartConfig() {
        this.setDefaultEncoding("UTF-8");
        this.setMaxUploadSize(5242880);
    }
}
