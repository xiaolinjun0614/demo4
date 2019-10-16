package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到会话
		HttpSession session = request.getSession();
		//得到表单提交的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//判断用户名和密码是否正确
		if ("admin".equals(name) && "123".equals(password)) {
			//登录成功，把用户信息保存到会话域中
			session.setAttribute("name", name);
			//登录成功，跳转到list.jsp显示所有的信息
			response.sendRedirect(request.getContextPath() + "/list.jsp");
		}
		else {
			//登录失败
			request.setAttribute("msg", "登录失败");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
