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
@Getter @Setter
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String name;
		private Boolean testResult;
		private String email;
		private String userName;
		private String password;
		
		@OneToMany(mappedBy = "user")
	    List<Visit> visits;
		public User() {
			
		}
		public void setUserName(String userID) {
			// TODO Auto-generated method stub
			
		}

		public void setPassword(String password2) {
			// TODO Auto-generated method stub
			
		}

		public void setName(String name2) {
			// TODO Auto-generated method stub
			
		}

		public void setEmail(String email2) {
			// TODO Auto-generated method stub
			
		}
		public void setTestResult(boolean b) {
			// TODO Auto-generated method stub
			
		}

		public char[] getEmail() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getUserName() {
			// TODO Auto-generated method stub
			return null;
		}

		
		

	
}
