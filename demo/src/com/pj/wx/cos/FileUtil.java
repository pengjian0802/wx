package com.pj.wx.cos;

import org.springframework.stereotype.Service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;

@Service
public class FileUtil {
	
	private Credentials cred;
	
	private COSClient cosClient;
	
	private String bucketName;
	
	{
		long appId = 1253484772;
        String secretId = "AKIDJXXGi0jxjR4e9bHi278tqY7RVJq7GpGQ";
        String secretKey = "1pMcbV7SXKp2yMlyvc5PedXCbjbCZqrb";
        // 设置要操作的bucket
        bucketName = "wx";
        // 初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
        clientConfig.setRegion("tj");
        // 初始化秘钥信息
        cred = new Credentials(appId, secretId, secretKey);
        // 初始化cosClient
        cosClient = new COSClient(clientConfig, cred);
	}
	
	public String upCosFile(String cosFilePath, String localFolePath){
//		long appId = 1253484772;
//        String secretId = "AKIDJXXGi0jxjR4e9bHi278tqY7RVJq7GpGQ";
//        String secretKey = "1pMcbV7SXKp2yMlyvc5PedXCbjbCZqrb";
//        // 设置要操作的bucket
//        bucketName = "wx";
//        // 初始化客户端配置
//        ClientConfig clientConfig = new ClientConfig();
//        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
//        clientConfig.setRegion("tj");
//        // 初始化秘钥信息
//        cred = new Credentials(appId, secretId, secretKey);
//        // 初始化cosClient
//        cosClient = new COSClient(clientConfig, cred);
        UploadFileRequest uploadFileRequest =
                new UploadFileRequest(bucketName, cosFilePath, localFolePath);
        uploadFileRequest.setEnableShaDigest(false);
        String uploadFileRet = cosClient.uploadFile(uploadFileRequest);
        return uploadFileRet;
	}
}
