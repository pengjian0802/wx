package com.pj.wx.uploader;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 后台处理上传文件
 * 
 * @author pengjian2
 *
 */
public class UpLoaderFile {
	
	static {
		System.out.println("UpLoaderFile_init.................");
	}
	
	/**
	 * 获取文件列表
	 * @param request
	 * @return
	 * @throws FileUploadException 
	 */
	public static List<FileItem> getFileList(HttpServletRequest request) throws FileUploadException{
		ServletFileUpload upload = null;
		org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload a=null; 
		try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            //设置上传时生成的临时文件的保存目录
//            factory.setRepository(tmpFile);
            //2、创建一个文件上传解析器
            upload = new ServletFileUpload(factory);
            //监听文件上传进度
            upload.setProgressListener(new ProgressListener(){
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                }
            });
             //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8"); 
            
            //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
            upload.setFileSizeMax(1024*1024);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
            upload.setSizeMax(1024*1024*10);
		 }catch (Exception e) {
            e.printStackTrace();
        }
		//使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		return upload.parseRequest(request);
	}
}
