package org.andvicoso.cruduser.controller.login;

import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class LoginController {
	@Autowired
	private UserDao dao;
	@Autowired
	private LoginManager manager;

	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login/doLogin", method = RequestMethod.POST)
	public String login(ModelMap model, HttpSession session,
			@RequestParam String login, @RequestParam String password) {
		User user = dao.findByLogin(login);

		if (user == null) {
			String msg = "Nenhum usuario encontrado com o login: '" + login
					+ "'!";
			return "redirect:error?errorMsg=" + msg;
		} else if (manager.verifyUser(password, user)) {
			String msg = "Senha inválida!";
			return "redirect:error?errorMsg=" + msg;
		} else {
			manager.populateSession(user, session);

			return "redirect:index";
		}
	}

	@RequestMapping(value = "/login/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "redirect:index";
	}
}
