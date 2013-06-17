package org.andvicoso.cruduser.model.dao;

import org.andvicoso.cruduser.model.domain.User;

public interface UserDao extends AbstractDao<User> {

	User findByLogin(String login);

}
