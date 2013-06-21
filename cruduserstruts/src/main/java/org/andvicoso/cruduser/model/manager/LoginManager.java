package org.andvicoso.cruduser.model.manager;

import java.util.Map;

import javax.inject.Named;

import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.utils.EncryptUtils;

@Named
public class LoginManager {
	public static final String USER_NAME = "userName";
	public static final String USER_ID = "userId";

	public void login(User user, Map<String, Object> session) {
		session.put(USER_ID, user.getId());
		session.put(USER_NAME, user.getName());
	}

	public void logout(Map<String, Object> session) {
		session.remove(USER_ID);
		session.remove(USER_NAME);
	}

	public boolean verifyUser(String password, User user) {
		String encrypted = EncryptUtils.encrypt(password);
		return user.getPassword().equals(encrypted);
	}
}
