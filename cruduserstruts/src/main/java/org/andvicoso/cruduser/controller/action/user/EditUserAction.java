package org.andvicoso.cruduser.controller.action.user;

import javax.inject.Inject;

import org.andvicoso.cruduser.controller.action.SecureAction;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class EditUserAction extends ActionSupport implements SecureAction{
	private Long id;
	private User user;
	@Inject
	private UserDao dao;

	@Action("edit")
	public String edit() {
		user = dao.find(id);
		return SUCCESS;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

}
