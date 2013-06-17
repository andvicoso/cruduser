package org.andvicoso.cruduser.model.dao;

import org.andvicoso.cruduser.model.domain.User;

public class UserDaoJPA extends AbstractDaoJPA<User> implements UserDao {

	public User findByLogin(String login) {
		String q = "SELECT u FROM User u WHERE u.login =:login";
		return createQuery(q).setParameter("login", login).getSingleResult();
	}

}
