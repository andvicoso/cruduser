package org.andvicoso.cruduser.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Length(max = 50)
	private String name;
	@NotEmpty
	@Length(max = 50)
	private String phone;
	@NotEmpty
	private String login;
	@NotEmpty
	@Length(min = 3, max = 10)
	private String password;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String pPhone) {
		phone = pPhone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
