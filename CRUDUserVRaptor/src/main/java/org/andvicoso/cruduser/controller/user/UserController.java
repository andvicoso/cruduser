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
		User oldUser = dao.find(user.getId());
		if (oldUser != null) {
			validator.checking(getValidations(user, true));
			validator.onErrorUsePageOf(UserController.class).edit(user.getId());

			if (StringUtils.isBlank(user.getPassword()))
				user.setPassword(oldUser.getPassword());

			dao.update(user);
		}
		result.redirectTo(this).list();
	}

	private Validations getValidations(final User user, final boolean isEdit) {
		return new Validations() {
			{
				that(StringUtils.isNotBlank(user.getName()), "error",
						"name.empty");
				that(StringUtils.isNotBlank(user.getPhone()), "error",
						"phone.empty");
				that(StringUtils.isNotBlank(user.getLogin()), "error",
						"login.empty");
				if (!isEdit)
					that(StringUtils.isNotBlank(user.getPassword()), "error",
							"password.empty");
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
	@Public
	public void put(User user) {
		validator.checking(getValidations(user, false));
		validator.onErrorUsePageOf(UserController.class).add();

		dao.create(user);
		result.redirectTo(this).list();
	}
}
