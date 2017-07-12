package com.kang.onlineshop.manager.service.impl;


import java.io.IOException;

import com.kang.onlineshop.common.pojo.PictureResult;
import com.kang.onlineshop.common.utils.IDUtils;
import com.kang.onlineshop.manager.service.PictureService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureServiceImpl implements PictureService {
	
//	@Value("${FTP_ADDRESS}")
//	private String FTP_ADDRESS;
//	@Value("${FTP_PORT}")
//	private Integer FTP_PORT;
//	@Value("${FTP_USERNAME}")
//	private String FTP_USER_NAME;
//	@Value("${FTP_PASSWORD}")
//	private String FTP_PASSWORD;
//	@Value("${FTP_BASE_PATH}")
//	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	

	@Override
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return PictureResult.error("上传图片为空");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		String path = imageName+ext;
		String url = IMAGE_BASE_URL + path;
		Client client = new Client();
	    WebResource resource = client.resource(url);
	    try {
	        resource.put(String.class, uploadFile.getBytes());
	    } catch (UniformInterfaceException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } catch (ClientHandlerException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	    return PictureResult.ok(IMAGE_BASE_URL + "/" + imageName + ext);
	}
	/**
	 * public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return PictureResult.error("上传图片为空");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		try {
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return PictureResult.error(ExceptionUtil.getStackTrace(e));
		}
		//返回结果，生成一个可以访问到图片的url返回
		
		return PictureResult.ok(IMAGE_BASE_URL + filePath + "/" + imageName + ext);
	}*/
}
