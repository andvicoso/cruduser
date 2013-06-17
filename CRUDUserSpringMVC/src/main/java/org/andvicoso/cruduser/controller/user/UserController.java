package org.andvicoso.cruduser.controller.user;

import java.util.List;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class UserController {
	@Autowired
	private UserDao dao;
	private static final String LIST = "list";
	private static final String REDIRECT = "redirect:";
	private static final String DIR_BAR = "user/";
	private static final String BDB = "/" + DIR_BAR;

	@RequestMapping(value = BDB + LIST, method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<User> users = dao.list();
		model.addAttribute("users", users);

		return DIR_BAR + LIST;
	}

	@RequestMapping(value = BDB + "remove", method = RequestMethod.POST)
	public String remove(@RequestParam Integer id) {
		dao.remove(id);

		return REDIRECT + BDB + LIST;
	}

	@RequestMapping(value = BDB + "update", method = RequestMethod.POST)
	public String update(@ModelAttribute User newUser, @RequestParam Integer id) {
		User user = dao.find(id);

		if (user != null) {
			user.setName(newUser.getName());
			user.setPhone(newUser.getPhone());
			dao.update(user);
		}
		return REDIRECT + BDB + LIST;
	}

	@RequestMapping(value = BDB + "edit", method = RequestMethod.GET)
	public String edit(ModelMap model, @RequestParam Integer id) {
		String result = LIST;
		User user = dao.find(id);

		if (user != null) {
			model.addAttribute("user", user);
			result = DIR_BAR + "edit";
		}
		return result;
	}

	@RequestMapping(value = BDB + "put", method = RequestMethod.POST)
	public String add(@ModelAttribute User user) {
		dao.create(user);

		return REDIRECT + BDB + LIST;
	}

	@RequestMapping(value = BDB + "add")
	public String add() {
		return DIR_BAR + "add";
	}
}
