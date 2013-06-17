package org.andvicoso.cruduser.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;

@ManagedBean
@ViewScoped
public class LoginController {
	private LoginManager manager;
	private UserDao dao;
	private String login;
	private String password;

	public void doLogin() throws IOException {
		dao = new UserDaoJPA();
		manager = new LoginManager();
		User user = dao.findByLogin(login);
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		String msg = "";

		if (user == null) {
			msg = "Nenhum usuario encontrado com o login: '" + login + "'!";
		} else if (manager.verifyUser(password, user)) {
			msg = "Senha inválida!";
		} else {
			HttpSession session = (HttpSession) ec.getSession(true);
			manager.populateSession(user, session);

			ec.redirect("/index.html");
		}

		if (!msg.isEmpty()) {
			fc.addMessage("login", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, msg));
			ec.dispatch("/error/error.xhtml");
		}
	}

	public String logout() {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		manager.removeSession(session);
		return "index";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
