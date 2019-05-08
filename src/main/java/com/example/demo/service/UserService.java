package com.example.demo.service;

import com.example.demo.entity.ResultServer;
import com.example.demo.entity.User;

public interface UserService {
	public ResultServer<Integer> register(User user);
	public ResultServer<Integer> login(String name,String password);
    public ResultServer<Integer> updateUser(User user);
    public ResultServer<Integer> findById(int id);
    public ResultServer<Integer> findByName(String name);
    public ResultServer<Integer> deleteById(int id);
    public ResultServer<Integer> findAllUser();
}
