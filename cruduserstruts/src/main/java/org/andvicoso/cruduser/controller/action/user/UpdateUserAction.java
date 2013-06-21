package org.andvicoso.cruduser.controller.action.user;

import javax.inject.Inject;
import javax.validation.Valid;

import org.andvicoso.cruduser.controller.action.SecureAction;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success", type = "redirectAction", params = { "actionName",
		"list" })
public class UpdateUserAction extends ActionSupport implements SecureAction {
	@Valid
	private User user = new User();
	@Inject
	private UserDao dao;

	private String password;

	@Action("update")
	public String update() {
		if (StringUtils.isNotBlank(password)) {
			User oldUser = dao.find(user.getId());
			user.setPassword(oldUser.getPassword());
		}
		dao.update(user);

		return SUCCESS;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
