package org.andvicoso.cruduser.model.dao;

import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;

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
