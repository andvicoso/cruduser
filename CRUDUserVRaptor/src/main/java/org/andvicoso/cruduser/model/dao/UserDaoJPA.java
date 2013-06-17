package org.andvicoso.cruduser.model.dao;

import org.andvicoso.cruduser.model.domain.User;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UserDaoJPA extends GenericDaoJPA<User> implements UserDao {

	public User findByLogin(String login) {
		String q = "SELECT u FROM User u WHERE u.login =:login";
		return createQuery(q).setParameter("login", login).getSingleResult();
	}

}
