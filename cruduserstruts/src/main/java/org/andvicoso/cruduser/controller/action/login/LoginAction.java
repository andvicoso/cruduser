package org.andvicoso.cruduser.controller.action.login;

import java.util.Map;

import javax.inject.Inject;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Results({
		@Result(name = "success", type = "redirectAction", params = {
				"actionName", "index" }),
		@Result(name = "input", location = "login.jsp") })
public class LoginAction extends ActionSupport implements SessionAware {

	private String login;
	private String password;
	private Map<String, Object> session;
	@Inject
	private UserDao dao;
	@Inject
	private LoginManager manager;

	@Action("login")
	public String login() {
		return "login";
	}

	@Action("doLogin")
	public String doLogin() {
		if (StringUtils.isEmpty(login))
			addActionError("Login vazio");
		if (StringUtils.isEmpty(password))
			addActionError("Senha vazia");

		if (StringUtils.isNotBlank(login)) {
			User user = dao.findByLogin(login);

			if (user == null) {
				addActionError("Nenhum usuario encontrado com o login: '"
						+ login + "'!");
			} else if (StringUtils.isNotBlank(password)
					&& manager.verifyUser(password, user)) {
				manager.login(user, session);
				return SUCCESS;
			} else {
				addActionError("Senha inválida!");
			}
		}
		return INPUT;
	}

	@Action("logout")
	public String logout() {
		manager.logout(session);

		return SUCCESS;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
