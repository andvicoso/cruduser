package org.andvicoso.cruduser.controller.action.user;

import javax.inject.Inject;

import org.andvicoso.cruduser.controller.action.SecureAction;
import org.andvicoso.cruduser.model.dao.UserDao;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name = "success", type = "redirectAction", params = { "actionName",
		"list" })
public class RemoveUserAction extends ActionSupport implements SecureAction {
	private Long id;
	@Inject
	private UserDao dao;

	@Action("remove")
	public String remove() {
		dao.remove(id);
		return SUCCESS;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
