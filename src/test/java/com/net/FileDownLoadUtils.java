package com.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoadUtils {

	public static HttpServletResponse response;
	public static HttpServletRequest request;

	public static void main(String[] args) throws IOException {
		// 设置下载的编码为utf-8
		response.setCharacterEncoding("utf-8");
		// 设置下载的响应格式
		response.setHeader("Content-Disposition", "attachment;fileName" + args[0]);

		// 获取下载文件的路径
		String uploadPath = request.getSession().getServletContext().getRealPath("");
		File file = new File(uploadPath + "/static/resources" + args[0]);
		// 读取下载的文件
		InputStream inputStream = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		os.close();
		inputStream.close();

	}
}
