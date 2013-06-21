package org.andvicoso.cruduser.controller.servlet.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/view/login/login.do")
public class LoginServlet extends HttpServlet {
	private static final String ERROR_JSP = "/view/error/error.jsp";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		LoginManager manager = new LoginManager();
		String login = pReq.getParameter("login");
		String password = pReq.getParameter("password");

		UserDao dao = new UserDaoJPA();
		User user = dao.findByLogin(login);

		String msg = "";

		if (user == null) {
			msg = "Nenhum usuário encontrado com o login: '" + login + "'!";
		} else if (StringUtils.isNotBlank(password)
				&& manager.verifyUser(password, user)) {
			manager.login(user, pReq.getSession());

			pResp.sendRedirect(pReq.getContextPath() + "/index.jsp");
		} else {
			msg = "Senha inválida!";
		}

		if (!msg.isEmpty()) {
			pReq.setAttribute("error", msg);
			RequestDispatcher rd = pReq.getRequestDispatcher(pReq
					.getContextPath() + ERROR_JSP);
			rd.forward(pReq, pResp);
		}
	}
}
