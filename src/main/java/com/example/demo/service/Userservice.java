package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface Userservice {

	public User add(User user);
	
	public List<User> getUsers();
	
	public User getUserById(int id);
	
	public User updateuser(User user,int id);
	
	public void deleteuser(int id);
}
