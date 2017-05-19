package com.pj.wx.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pj.wx.cos.FileUtil;
import com.pj.wx.entity.Item;
import com.pj.wx.entity.ItemDetail;
import com.pj.wx.service.ItemDetailService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;

@Controller
public class UpLoaderController {

	@Autowired
	private FileUtil fileUtil;
	
	@Autowired
	private ItemDetailService itemDetailService;

	@RequestMapping("/uploaderFile")
	public String uploaderFile(HttpServletRequest request) throws IOException, FileUploadException {
		ItemDetail itemDetail = new ItemDetail();
		String cosName = System.currentTimeMillis() +"";
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getServletContext().getRealPath("/WEB-INF/images");
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
		factory.setSizeThreshold(1024 * 100);
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 监听文件上传进度
		upload.setProgressListener(new ProgressListener() {
			@Override
			public void update(long pBytesRead, long pContentLength, int arg2) {
				System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
			}
		});
		// 4、使用ServletFileUpload解析器解析上传数据
		List<FileItem> list = upload.parseRequest(request);
		for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {//表单数据
				String itemId = fileItem.getString();
				itemDetail.setItemId(Long.parseLong(itemId));
			} else {
				String fileName = fileItem.getName();
				if (StringUtils.isEmpty(fileName)) {
					continue;
				}
				String suffix = fileName.substring(fileName.indexOf("."));
				InputStream input = fileItem.getInputStream();
				FileOutputStream output = new FileOutputStream(savePath + "\\" + fileName);
				// 创建一个缓冲区
				byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				while ((len = input.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" +
					// filename)当中
					output.write(buffer, 0, len);
				}
				// 关闭输入流
				input.close();
				// 关闭输出流
				output.close();
				fileUtil.upCosFile("/images/"+cosName+suffix, savePath + "\\" + fileName);
				// 删除处理文件上传时生成的临时文件
				fileItem.delete();
				itemDetail.setImgUrl("http://wx-1253484772.costj.myqcloud.com"+"/images/"+cosName+suffix);
				itemDetailService.save(itemDetail);
			}
		}
		return "success";
	}
}
