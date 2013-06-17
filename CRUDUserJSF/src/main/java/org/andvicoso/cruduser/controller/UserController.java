package org.andvicoso.cruduser.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;

@ManagedBean
@ViewScoped
public class UserController implements Serializable {

	private UserDao dao;
	private User user = new User();
	private List<User> users;

	@PostConstruct
	public void init() {
		dao = new UserDaoJPA();
		users = dao.list();
	}

	public String add() {
		dao.create(user);
		user = new User();
		return "list";
	}

	public String edit(User user) {
		this.user = user;
		return "edit";
	}

	public String save(User user) {
		dao.update(user);
		user = new User();
		return "list";
	}

	public String delete(User user) {
		dao.remove(user.getId());
		return "list";
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}
}
