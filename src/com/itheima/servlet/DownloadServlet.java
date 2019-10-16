package com.itheima.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 读取所需要下载的文件
		String real = request.getServletContext().getRealPath("/WEB-INF/download/美女.jpg");
		//创建一个输入流
		FileInputStream fis = new FileInputStream(real);
		//2. 指定响应头
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("美女.jpg", "utf-8"));
		//3.得到输出流
		OutputStream os = response.getOutputStream();
		//开始下载
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = fis.read(buf))!=-1) {
			os.write(buf, 0, len);
		}
		//关闭流
		fis.close();
		os.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
