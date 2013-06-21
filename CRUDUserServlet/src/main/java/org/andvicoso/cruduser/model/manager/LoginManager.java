package org.andvicoso.cruduser.model.manager;

import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.utils.EncryptUtils;

public class LoginManager {
	public static final String USER_NAME = "userName";
	public static final String USER_ID = "userId";

	public void login(User user, HttpSession session) {
		session.setAttribute(USER_ID, user.getId());
		session.setAttribute(USER_NAME, user.getName());
	}

	public void logout(HttpSession session) {
		session.removeAttribute(USER_ID);
		session.removeAttribute(USER_NAME);
	}

	public boolean verifyUser(String password, User user) {
		String encrypted = EncryptUtils.encrypt(password);
		return user.getPassword().equals(encrypted);
	}
}
