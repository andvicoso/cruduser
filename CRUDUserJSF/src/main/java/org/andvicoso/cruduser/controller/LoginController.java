package org.andvicoso.cruduser.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
import org.apache.commons.lang3.StringUtils;

@ManagedBean
@RequestScoped
public class LoginController extends BaseController {
	private UserDao dao;
	private String login;
	private String password;

	public String doLogin() throws IOException {
		LoginManager manager = new LoginManager();
		dao = new UserDaoJPA();
		User user = dao.findByLogin(login);

		String msg = "";

		if (user == null) {
			msg = "Nenhum usuário encontrado com o login: '" + login + "'!";
		} else if (StringUtils.isNotBlank(password)
				&& manager.verifyUser(password, user)) {
			manager.login(user, getSession(true));
		} else {
			msg = "Senha inválida!";
		}

		boolean ok = msg.isEmpty();

		if (ok) {
			addError("login", msg);
		}

		return ok ? INDEX : ERROR;
	}

	public String logout() {
		LoginManager manager = new LoginManager();
		manager.logout(getSession(false));

		return INDEX;
	}

	public String index() {
		return INDEX;
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
