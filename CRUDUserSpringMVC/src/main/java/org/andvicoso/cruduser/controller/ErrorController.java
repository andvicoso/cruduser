package org.andvicoso.cruduser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {
	@RequestMapping(value = "/error")
	public String error(@RequestParam String errorMsg) {
		return "error";
	}

}
