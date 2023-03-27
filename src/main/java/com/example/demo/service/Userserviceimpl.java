package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.Userrepo;

@Service
public class Userserviceimpl implements Userservice{

	@Autowired
	Userrepo userrepo;
	
	@Override
	public User add(User user) {
		return userrepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userrepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userrepo.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
	}

	@Override
	public User updateuser(User newuser,int id) {
		return  userrepo.findById(id)
				.map(user -> {
					user.setUsername(newuser.getUsername());
					user.setName(newuser.getName());
					user.setEmail(newuser.getEmail());
					return userrepo.save(user);
				}).orElseThrow(()-> new UserNotFoundException(id));
	
	}

	@Override
	public void deleteuser(int id) {
		
		if(!userrepo.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		
		userrepo.deleteById(id);
		
	}

	

}
