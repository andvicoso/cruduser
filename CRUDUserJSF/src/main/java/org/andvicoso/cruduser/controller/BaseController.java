package org.andvicoso.cruduser.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class BaseController implements Serializable {

	public static final String INDEX = "/index";
	public static final String ERROR = "/view/error/error";

	protected void addError(String clientId, String msg) {
		FacesContext.getCurrentInstance().addMessage("login",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}

	protected HttpSession getSession(boolean create) {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		return (HttpSession) ec.getSession(create);
	}

	protected void addToRequest(String key, Object obj) {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		ec.getRequestMap().put(key, obj);
	}

	protected void dispatch(String url) {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			ec.dispatch(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
