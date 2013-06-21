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

import org.andvicoso.cruduser.model.manager.LoginManager;

@WebFilter(urlPatterns = { "/view/user/edit.xhtml" })
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest pReq, ServletResponse pResp,
			FilterChain pChain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) pResp;
		HttpServletRequest req = (HttpServletRequest) pReq;
		HttpSession session = req.getSession(false);

		if (session != null
				&& session.getAttribute(LoginManager.USER_ID) != null)
			pChain.doFilter(pReq, pResp);
		else {
			res.sendRedirect(req.getContextPath() + "/view/login/login.xhtml");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
