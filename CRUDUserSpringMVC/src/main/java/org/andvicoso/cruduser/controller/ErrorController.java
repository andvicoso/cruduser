package org.andvicoso.cruduser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping(value = "/error")
	public String error(ModelMap model) {
		return "error/error";
	}

}
