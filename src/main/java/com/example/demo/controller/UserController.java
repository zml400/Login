package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResultServer;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public ResultServer<Integer> register(User user) {
		ResultServer<Integer> resultServer=userService.register(user);
		return resultServer;
	}
	
	@RequestMapping("/login")
	public ResultServer<Integer> login(@RequestParam String name,@RequestParam String password) {
		ResultServer<Integer> resultServer=userService.login(name,password);
		return resultServer;
	}
	
	@RequestMapping("/update")
	public ResultServer<Integer> updata(User user){
		ResultServer<Integer> resultServer=userService.updateUser(user);
		return resultServer;
	}
	@RequestMapping(value = "/findUserById")
	public ResultServer<Integer> findUser(@RequestParam int id) {
		ResultServer<Integer> resultServer=userService.findById(id);
		return resultServer;
	}
	@RequestMapping(value = "/findUserByName/{name}")
	public ResultServer<Integer> findUser(@PathVariable("name") String name) {
		ResultServer<Integer> resultServer=userService.findByName(name);
		return resultServer;
	}
	@RequestMapping(value = "/findAllUser")
	public ResultServer<Integer> findAllUser() {
		ResultServer<Integer> resultServer=userService.findAllUser();
		return resultServer;
	}
	@RequestMapping(value = "/deleteById/{id}")
	public ResultServer<Integer> deleteUser(@PathVariable("id") int id,Model model) {
		ResultServer<Integer> resultServer=userService.deleteById(id);
		return resultServer;
	}
}
