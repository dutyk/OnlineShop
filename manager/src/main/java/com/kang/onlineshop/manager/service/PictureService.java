package com.kang.onlineshop.manager.service;

import com.kang.onlineshop.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;


public interface PictureService {
	public PictureResult uploadPicture(MultipartFile uploadFile);
}
