package org.andvicoso.cruduser.model.manager;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.utils.CriptoUtils;

public class LoginManager {
	public void populateSession(User user, HttpSession session) {
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
	}

	public boolean verifyUser(String password, User user) {
		try {
			byte[] b = CriptoUtils.digest(password.getBytes(), CriptoUtils.MD5);
			String senhaCriptografada = CriptoUtils.byteArrayToHexString(b);

			if (user.getPassword().equalsIgnoreCase(senhaCriptografada)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return false;
	}
}
