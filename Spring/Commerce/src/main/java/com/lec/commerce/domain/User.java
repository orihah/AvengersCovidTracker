package com.lec.commerce.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Boolean testResult;
	private String email;
	private String userName;
	private String password;

	@OneToMany(mappedBy = "user")
	List<Visit> visits;

	public User(String name, String email, int id, String password, boolean testResult) {

	}

	User CreateUser(String name, String email, int id, String password, boolean testResult) {
		return new User(name, email, id, password, testResult);

	}

	boolean ConfirmUser(String name, String password) {
		if (this.name == name && this.password == password) {
			return true;
		} else
			return false;
	}

}
