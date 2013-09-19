package org.andvicoso.cruduser.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.dao.UserDaoJPA;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;

@ManagedBean
@SessionScoped
public class UserController extends BaseController {

	private static final String LIST = "list?faces-redirect=true";
	private UserDao dao;
	private User user;
	private List<User> users;
	private String password;

	@PostConstruct
	public void init() {
		user = new User();
		dao = new UserDaoJPA();
		users = dao.list();
	}

	public String add() {
		dao.create(user);
		user = new User();

		return LIST;
	}

	public void edit(User user) {
		this.user = user;
		this.password = user.getPassword();
	}

	public String save() {
		if (StringUtils.isNotBlank(password))
			user.setPassword(password);
		dao.update(user);
		user = new User();
		
		return LIST;
	}

	public String delete(User user) {
		dao.remove(user.getId());
		
		return LIST;
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
