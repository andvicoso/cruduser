package org.andvicoso.cruduser.controller.action.user;

import javax.inject.Inject;
import javax.validation.Valid;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({
		@Result(name = "success", type = "redirectAction", params = {
				"actionName", "list" }),
		@Result(name = "input", location = "add.jsp") })
public class AddUserAction extends ActionSupport {
	@Valid
	private User user = new User();
	@Inject
	private UserDao dao;

	@Action("add")
	public String add() {
		return INPUT;
	}

	@Action("put")
	public String put() {
		dao.create(user);
		return SUCCESS;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
