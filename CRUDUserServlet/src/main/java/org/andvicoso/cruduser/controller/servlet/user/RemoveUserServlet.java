package org.andvicoso.cruduser.controller.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andvicoso.cruduser.model.dao.UserDaoJPA;

@WebServlet(urlPatterns = { "/view/user/remove.do" })
public class RemoveUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest pReq, HttpServletResponse pResp)
			throws ServletException, IOException {
		String id = pReq.getParameter("id");
		UserDaoJPA dao = new UserDaoJPA();

		long idl = Long.parseLong(id);
		dao.remove(idl);

		pResp.sendRedirect("list.do");
	}
}
