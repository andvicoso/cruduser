package org.andvicoso.cruduser.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/view/user/remove.do", "/view/user/edit.do",
		"/view/user/editSave.do" })
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest pReq, ServletResponse pResp,
			FilterChain pChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) pReq;
		HttpServletResponse resp = (HttpServletResponse) pResp;

		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("userId") != null)
			pChain.doFilter(pReq, pResp);
		else
			resp.sendRedirect(req.getContextPath()
					+ "/view/error/loginFilterError.jsp");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
