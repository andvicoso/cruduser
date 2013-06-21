package org.andvicoso.cruduser.controller.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;

@WebServlet(urlPatterns = { "/view/user/list.do" })
public class ListUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		UserDao dao = new UserDaoJPA();
		pReq.setAttribute("users", dao.list());
		RequestDispatcher rd = pReq.getRequestDispatcher("list.jsp");
		rd.forward(pReq, pResp);
	}
}
