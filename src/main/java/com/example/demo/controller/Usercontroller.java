package com.example.demo.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.Userrepo;
import com.example.demo.service.Userservice;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class Usercontroller {
	
	
	@Autowired
	Userservice userservice;
	

	
	@PostMapping("/add")
	public String adduser(@RequestBody User user) {
		userservice.add(user);
		return "New user added";
	}
	
	@GetMapping("/getusers")
	public List<User> getAllUsers(){
		return userservice.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id){
		return userservice.getUserById(id);
	}
	
	@PutMapping("/updateuser/{id}")
	public String updateUser(@RequestBody User user, @PathVariable int id) {
		userservice.updateuser(user, id);
		return "User updated with id "+ id ;
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id){
		
		userservice.deleteuser(id);
		return "User has been deleted with id "+ id ;
	}
}
