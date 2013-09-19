package org.andvicoso.cruduser.controller.action.user;

import java.util.List;

import javax.inject.Inject;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class ListUserAction extends ActionSupport {
	@Inject
	private UserDao dao;
	private List<User> users;

	@Action("list")
	public String list() {
		users = dao.list();
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}

}
