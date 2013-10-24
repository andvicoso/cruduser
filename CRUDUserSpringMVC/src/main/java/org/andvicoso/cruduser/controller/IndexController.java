package org.andvicoso.cruduser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String mainPage() {
		return "index";
	}

	@RequestMapping(value = "/index")
	public String indexPage() {
		return "index";
	}

}