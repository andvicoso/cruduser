package org.andvicoso.cruduser.controller.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;

@WebServlet("/view/login/login.do")
public class LoginServlet extends HttpServlet {
	private static final String ERROR_JSP = "../error/error.jsp?msg=";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		LoginManager manager = new LoginManager();
		String login = pReq.getParameter("login");
		String password = pReq.getParameter("password");

		UserDao dao = new UserDaoJPA();
		User user = dao.findByLogin(login);

		if (user == null) {
			String msg = "Nenhum usuario encontrado com o login: '" + login
					+ "'!";
			pResp.sendRedirect(ERROR_JSP + msg);
		} else if (manager.verifyUser(password, user)) {
			String msg = "Senha inválida!";
			pResp.sendRedirect(ERROR_JSP + msg);
		} else {
			HttpSession session = pReq.getSession();
			manager.populateSession(user, session);

			pResp.sendRedirect(pReq.getContextPath() + "/index.jsp");
		}
	}
}
