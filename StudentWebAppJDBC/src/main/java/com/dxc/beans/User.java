package com.dxc.beans;

import java.io.Serializable;

public class User implements Serializable,Comparable<User> {
	String username;
	String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	@Override
	public int compareTo(User arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	 
}
