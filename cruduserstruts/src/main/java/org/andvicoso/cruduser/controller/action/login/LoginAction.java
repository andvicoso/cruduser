package org.andvicoso.cruduser.controller.action.login;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.inject.Inject;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.utils.CriptoUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "success", location = "/index.jsp"),
		@Result(name = "input", location = "login.jsp") })
public class LoginAction extends ActionSupport implements SessionAware {

	private String login;
	private String password;
	private Map<String, Object> session;
	@Inject
	private UserDao dao;

	@Action("login")
	public String login() {
		return "login";
	}

	@Action("doLogin")
	public String doLogin() {
		if (StringUtils.isEmpty(login))
			addActionError("Login vazio");
		if (StringUtils.isEmpty(password))
			addActionError("Login vazio");

		if (StringUtils.isNotEmpty(login) && StringUtils.isNotEmpty(password)) {
			User user = dao.findByLogin(login);

			if (user == null) {
				addActionError("Nenhum usuario encontrado com o login: '"
						+ login + "'!");
				return INPUT;
			} else if (verifyUser(password, user)) {
				addActionError("Senha inválida!");
				return INPUT;
			} else {
				session.put("userId", user.getId());
				session.put("userName", user.getName());

				return SUCCESS;
			}
		}
		return INPUT;
	}

	private boolean verifyUser(String password, User user) {
		try {
			byte[] b = CriptoUtils.digest(password.getBytes(), "md5");
			String senhaCriptografada = CriptoUtils.byteArrayToHexString(b);

			if (user.getPassword().equalsIgnoreCase(senhaCriptografada)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Action("logout")
	public String logout() {
		session.remove("userId");
		session.remove("userName");
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
