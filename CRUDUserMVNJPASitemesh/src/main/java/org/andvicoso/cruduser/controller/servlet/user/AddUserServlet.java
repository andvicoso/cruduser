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

@WebServlet(urlPatterns = { "/view/user/add.do" })
public class AddUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		String name = pReq.getParameter("name");
		String phone = pReq.getParameter("phone");

		User user = new User();
		user.setName(name);
		user.setPhone(phone);

		UserDao dao = new UserDaoJPA();
		dao.create(user);

		pResp.sendRedirect("list.do");
	}
}
