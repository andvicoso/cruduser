package org.andvicoso.cruduser.model.dao;

import javax.inject.Named;

import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;

@Named
public class UserDaoJPA extends GenericDaoJPA<User> implements UserDao {

	public User findByLogin(String login) {
		if (StringUtils.isNotBlank(login)) {
			String q = "SELECT u FROM User u WHERE u.login =:login";
			return createQuery(q).setParameter("login", login)
					.getSingleResult();
		}
		return null;
	}

}
