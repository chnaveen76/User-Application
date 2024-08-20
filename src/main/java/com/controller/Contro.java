package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.ServiceClass;

@RestController
public class Contro {
	@Autowired
	private ServiceClass service;

	@GetMapping("/hello")
	public String helloWorld() {
		return "hello world";
	}

	@GetMapping("/user/{username}")
	public User getUser(@PathVariable("username") String username) {
		System.out.println("hello");
		User userDetails = service.userDetails(username);
		System.out.println(userDetails);
		return userDetails;

	}

	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		System.out.println("in controller");
		service.saveUser(user);
		return "succesfully saved";
	}

	@PutMapping("/update")
	public String updateUser(@RequestBody User user) throws Exception {
		System.out.println("In controller");
		service.userUpdate(user);
		return "Updation Succesfully Completed";
	}
	@PatchMapping("/update1")
	public String updatingUser(@RequestBody User user) throws Exception {
		System.out.println("in controller");
		service.updatingPatchUser(user);
		return "updation succesfully completed";
	}
	
	@DeleteMapping("/user/{username}")
	public String deleteUser(@PathVariable("username") String username) {
		service.delete(username);
		return "deletion completed succesfully";
	}
	
	

}
