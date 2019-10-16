package com.itheima.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限过滤器
 * @author NewBoy
 *
 */
public class LoginAuthorityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断用户是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		//得到会话对象
		HttpSession session = req.getSession();
		//判断会话中是否有指定的用户信息
		String name = (String) session.getAttribute("name");
		if (name == null) {  //表示没有登录
			req.setAttribute("msg", "您是非法用户，请先登录");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
			//不再继续向后运行
			return;
		}
		else {
			//是正常登录的用户，放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
