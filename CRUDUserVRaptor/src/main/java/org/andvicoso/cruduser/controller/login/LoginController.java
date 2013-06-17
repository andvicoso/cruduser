package org.andvicoso.cruduser.controller.login;

import java.security.NoSuchAlgorithmException;

import org.andvicoso.cruduser.controller.IndexController;
import org.andvicoso.cruduser.model.LoginInfo;
import org.andvicoso.cruduser.model.Public;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.utils.CriptoUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class LoginController {

	private UserDao dao;
	private Result result;
	private Validator validator;
	private LoginInfo loginInfo;

	public LoginController(UserDao dao, LoginInfo info, Result result,
			Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.loginInfo = info;
	}

	@Post
	@Public
	public void doLogin(String login, String password) {
		validator.checking(getLoginValidations(login, password));
		validator.onErrorUsePageOf(LoginController.class).login();
		User user = dao.findByLogin(login);

		if (user != null) {
			loginInfo.setUserId(user.getId());
			loginInfo.setUserName(user.getName());
		}

		result.redirectTo(IndexController.class).index();
	}

	private Validations getLoginValidations(final String login,
			final String password) {

		return new Validations() {
			{
				if (StringUtils.isNotEmpty(login)) {
					final User user = dao.findByLogin(login);
					that(user != null, "error", "login.invalid");
					that(!verifyUser(password, user), "password",
							"password.invalid");
				}

				that(StringUtils.isNotEmpty(login), "error", "login.empty");
				that(StringUtils.isNotEmpty(password), "error",
						"password.empty");
			}
		};
	}

	private boolean verifyUser(String password, User user) {
		if (StringUtils.isNotEmpty(password)) {
			try {
				byte[] b = CriptoUtils.digest(password.getBytes(),
						CriptoUtils.MD5);
				String senhaCriptografada = CriptoUtils.byteArrayToHexString(b);

				if (user.getPassword().equalsIgnoreCase(senhaCriptografada)) {
					return true;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Get
	public void logout() {
		loginInfo.logout();
		result.redirectTo(IndexController.class).index();
	}

	@Get
	@Public
	public void login() {
	}
}
