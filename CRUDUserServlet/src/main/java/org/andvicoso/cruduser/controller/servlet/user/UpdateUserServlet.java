package org.andvicoso.cruduser.controller.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;

@WebServlet(urlPatterns = { "/view/user/update.do" })
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		String id = pReq.getParameter("id");
		UserDao dao = new UserDaoJPA();
		long idl = Long.parseLong(id);
		User user = dao.find(idl);

		if (user != null) {
			String name = pReq.getParameter("name");
			String phone = pReq.getParameter("phone");
			String login = pReq.getParameter("login");
			String password = pReq.getParameter("password");

			if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(phone)
					&& StringUtils.isNotBlank(login)) {
				user.setName(name);
				user.setPhone(phone);
				user.setLogin(login);

				if (StringUtils.isNotBlank(password))
					user.setPassword(password);

				dao.update(user);
				pResp.sendRedirect("list.do");
			} else {
				pResp.sendRedirect("edit.do?id=" + id);
			}
		} else {
			pResp.sendRedirect("list.do");
		}
	}

}
