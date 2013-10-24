package org.andvicoso.cruduser.controller.user;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.andvicoso.cruduser.model.dao.UserDao;
import org.andvicoso.cruduser.model.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	@Inject
	private UserDao dao;
	private static final String LIST = "/user/list";
	private static final String REDIRECT = "redirect:";

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<User> users = dao.list();
		model.addAttribute("users", users);

		return LIST;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam Integer id) {
		dao.remove(id);

		return REDIRECT + LIST;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute User newUser, @RequestParam Integer id) {
		User user = dao.find(id);

		if (user != null) {
			if (StringUtils.isBlank(newUser.getPassword()))
				newUser.setPassword(user.getPassword());
			dao.update(user);
		}
		return REDIRECT + LIST;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(ModelMap model, @RequestParam Integer id) {
		String result = LIST;
		User user = dao.find(id);

		if (user != null) {
			model.addAttribute(user);
			result = "/user/edit";
		}
		return result;
	}

	@RequestMapping(value = "/put", method = RequestMethod.POST)
	public String put(@ModelAttribute @Valid User user, BindingResult result) {
		if (!result.hasErrors()) {
			dao.create(user);
			return REDIRECT + LIST;
		} else
			return "/user/add";
	}

	@RequestMapping(value = "add")
	public String add() {
		return "/user/add";
	}
}
