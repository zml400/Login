package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserDao {
	 public void insert(User user);
	 public void update(User user);
	 public void deleteById(int id);
	 public User findById(int id);
	 public User findByName(String name);
	 public List<User> findAllUser();
}
