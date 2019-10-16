package com.itheima.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自己写一个上传的功能，实现文本文件的上传
 * @author NewBoy
 *
 */
public class Upload1Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到请求的输入流
		InputStream in = request.getInputStream();
		//使用缓存字符输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//读取数据，读取第一行：开始分隔符
		String startTag = br.readLine();
		String disposition = br.readLine();
		//通过取子串的方式得到文件名
		String fileName = disposition.substring(disposition.indexOf("filename") + 10, disposition.length() - 1);
		System.out.println(fileName);
		//得到upload路径
		String uploadFile = request.getServletContext().getRealPath("/upload") + "/" + fileName;
		System.out.println(uploadFile);
		//得到MIME类型
		String contentType = br.readLine();
		//从Content-Type: 空格开始
		contentType = contentType.substring(14);
		System.out.println(contentType);
		//读取一个空行，忽略
		br.readLine();
		//创建一个缓存字符输出流
		BufferedWriter bw = new BufferedWriter(new FileWriter(uploadFile));
		String line = null;
		while((line = br.readLine())!=null) {
			//如果是结束的标记
			if (line.equals(startTag + "--")) {
				break;
			}
			bw.write(line);
			bw.newLine();
		}
		//关闭
		bw.close();
		br.close();
		response.getOutputStream().write((fileName + "上传成功").getBytes());
	}

}
