package org.andvicoso.cruduser.controller.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.andvicoso.cruduser.model.manager.LoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	private static final String DIR = "/login/";
	@Inject
	private UserDao dao;
	@Inject
	private LoginManager manager;

	@RequestMapping(value = DIR + "login", method = RequestMethod.GET)
	public String login() {
		return DIR + "login";
	}

	@RequestMapping(value = DIR + "doLogin", method = RequestMethod.POST)
	public String login(ModelMap model, HttpSession session,
			HttpServletRequest req, @RequestParam String login,
			@RequestParam String password) {
		User user = dao.findByLogin(login);
		String error = "";

		if (user == null) {
			error = "Nenhum usuário encontrado com o login: '" + login + "'!";
		} else if (manager.verifyUser(password, user)) {
			manager.login(user, session);
		} else {
			error = "Senha inválida!";
		}

		if (!error.isEmpty()) {
			model.addAttribute("error", error);
		}

		return "redirect:../" + (error.isEmpty() ? "index" : "error");
	}

	@RequestMapping(value = DIR + "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../index";
	}
}
