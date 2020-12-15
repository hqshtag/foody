package com.imset.foody.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity // This tells Hibernate to make a table out of this class
public class User {
	
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer id;
	private String email;
	private String password;
	private String name;
	private String state;
	
	public User(){
		
	}
	
	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	User(String email, String password, String name, String state) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.state = state;
	}
	

	/*
	 * public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * public void hashPassword(){
	 * this.setPassword(bCryptPasswordEncoder.encode(this.getPassword()); }
	 */
	



	
	//SETTERS AND GETTERS
	//ID
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//Email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	//PASSWORD
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//NAME
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//STATE
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", state=" + state
				+ "}";
	}


}