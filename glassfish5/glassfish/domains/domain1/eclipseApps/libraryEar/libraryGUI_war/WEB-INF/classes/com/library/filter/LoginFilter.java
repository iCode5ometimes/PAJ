package com.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.managedBean.LoginBean;

@WebFilter(urlPatterns = { "/pages/bookList.xhtml", "/pages/borrowOrder.xhtml", "/pages/userBorrowOrders.xhtml" })
public class LoginFilter implements Filter {

	public static final String LOGIN_PAGE = "/index.xhtml";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		LoginBean loginBean = (LoginBean) httpServletRequest.getSession().getAttribute("loginBean");

		if (loginBean != null && loginBean.getUserDTO() != null) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
		}
	}

}
