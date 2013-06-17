package org.andvicoso.cruduser.model;

public class LoginInfo {
	private Long userId;
	private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isLogged() {
		return userId != null;
	}

	public void logout() {
		userId = null;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
