package org.andvicoso.cruduser.controller.user;

import java.util.List;

import org.andvicoso.cruduser.model.Public;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class UserController {
	private UserDao dao;
	private Result result;
	private Validator validator;

	public UserController(UserDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get
	@Public
	public List<User> list() {
		return dao.list();
	}

	@Post
	public void remove(Integer id) {
		dao.remove(id);
		result.redirectTo(this).list();
	}

	@Post
	public void update(User user) {
		if (dao.find(user.getId()) != null) {
			validator.checking(getUserValidations(user));
			validator.onErrorUsePageOf(UserController.class).edit(user.getId());
			dao.update(user);
		}
		result.redirectTo(this).list();
	}

	private Validations getUserValidations(final User user) {
		return new Validations() {
			{
				that(StringUtils.isNotEmpty(user.getName()), "error",
						"name.empty");
				that(StringUtils.isNotEmpty(user.getLogin()), "error",
						"login.empty");
				that(StringUtils.isNotEmpty(user.getPassword()), "error",
						"password.empty");
				that(StringUtils.isNotEmpty(user.getPhone()), "error",
						"phone.empty");
			}
		};
	}

	@Get
	public User edit(Long id) {
		return dao.find(id);
	}

	@Get
	@Public
	public void add() {
	}

	@Post
	public void put(User user) {
		validator.checking(getUserValidations(user));
		validator.onErrorUsePageOf(UserController.class).add();

		dao.put(user);
		result.redirectTo(this).list();
	}
}
