package com.kang.onlineshop.manager.controller;

import com.kang.onlineshop.common.pojo.PictureResult;
import com.kang.onlineshop.manager.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yuankang on 2017/7/3.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/pic/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile) {
        PictureResult result = pictureService.uploadPicture(uploadFile);
        return result;
    }
}
