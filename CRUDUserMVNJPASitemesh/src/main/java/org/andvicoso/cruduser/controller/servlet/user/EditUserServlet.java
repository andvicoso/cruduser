package org.andvicoso.cruduser.controller.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;

@WebServlet(urlPatterns = { "/view/user/edit.do" })
public class EditUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		long id = Long.parseLong(pReq.getParameter("id"));
		UserDaoJPA dao = new UserDaoJPA();
		User user = dao.find(id);

		if (user != null) {
			pReq.setAttribute("user", user);

			RequestDispatcher rd = pReq.getRequestDispatcher("edit.jsp");
			rd.forward(pReq, pResp);
		}else{
			pResp.sendRedirect("list.do");
		}
	}

}
