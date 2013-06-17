package org.andvicoso.cruduser.controller.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	@Action("index")
	public String index() {
		return SUCCESS;
	}
}
