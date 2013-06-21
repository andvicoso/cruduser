package org.andvicoso.cruduser.controller.login;

import org.andvicoso.cruduser.controller.IndexController;
import org.andvicoso.cruduser.model.LoginInfo;
import org.andvicoso.cruduser.model.Public;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
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
	private LoginManager manager;

	public LoginController(UserDao dao, LoginInfo info, LoginManager manager,
			Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.loginInfo = info;
		this.manager = manager;
	}

	@Post
	@Public
	public void doLogin(String login, String password) {
		User user = dao.findByLogin(login);
		validator.checking(getLoginValidations(login, user, password));
		validator.onErrorUsePageOf(LoginController.class).login();

		if (!validator.hasErrors()) {
			loginInfo.setUserId(user.getId());
			loginInfo.setUserName(user.getName());
		}

		result.redirectTo(IndexController.class).index();
	}

	private Validations getLoginValidations(final String login,
			final User user, final String password) {

		return new Validations() {
			{
				if (StringUtils.isNotBlank(login)) {
					that(user != null, "error", "login.invalid");
					that(!manager.verifyUser(password, user), "password",
							"password.invalid");
				}

				that(StringUtils.isNotBlank(login), "error", "login.empty");
				that(StringUtils.isNotBlank(password), "error",
						"password.empty");
			}
		};
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
