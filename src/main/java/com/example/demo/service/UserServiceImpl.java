package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.ResultServer;
import com.example.demo.entity.User;

@ComponentScan(value={"com.example.demo.dao"})
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
	
	//用户注册
	@Override
	public ResultServer<Integer> register(User user){
		ResultServer<Integer> resultServer = new ResultServer<Integer>();
		if(user.getName()==null) {
			resultServer.setCode(401);
			resultServer.setMessage("姓名输入为空,请重新输入");
			return resultServer;
		}else if(user.getPassword()==null){
			resultServer.setCode(402);
			resultServer.setMessage("密码输入为空,请重新输入");
			return resultServer;
		}
		userDao.insert(user);
		resultServer.setCode(200);
		resultServer.setMessage("注册成功");
		resultServer.setData(user);
        return resultServer;
	}
	
	//用户登录
    @Override
    public ResultServer<Integer> login(String name,String password) {
    	ResultServer<Integer> resultServer = new ResultServer<Integer>();
    	if(name==null) {
			resultServer.setCode(401);
			resultServer.setMessage("姓名输入为空,请重新输入");
			return resultServer;
		}else if(password==null){
			resultServer.setCode(402);
			resultServer.setMessage("密码输入为空,请重新输入");
			return resultServer;
		}
    	User user = userDao.findByName(name);
    	if(user!=null) {
    		if(user.getPassword()==password) {
	    		resultServer.setCode(200);
				resultServer.setMessage(name+":登陆成功");
				resultServer.setData(user);
    		}else {
    			resultServer.setCode(403);
    			resultServer.setMessage("密码输入有误，请重新输入");
			}
    	}else {
    		resultServer.setCode(400);
			resultServer.setMessage("你输入的用户不存在");
		}
        return resultServer;
    }
    
    //根据id更新用户数据
    @Override
    public ResultServer<Integer> updateUser(User user){
    	ResultServer<Integer> resultServer = new ResultServer<Integer>();
    	if(userDao.findById(user.getId())!=null) {
    		userDao.update(user);
    		resultServer.setCode(200);
    		resultServer.setMessage(user.getName()+"更新成功");
    		resultServer.setData(user);
    	}else {
			resultServer.setCode(400);
			resultServer.setMessage("你输入的id有误");
		}
    	return resultServer;
    }
    
    //根据id查找用户
    @Override
    public ResultServer findById(int id) {
    	ResultServer<Integer> resultServer = new ResultServer<Integer>();
        User user=userDao.findById(id);
        if(user!=null) {
	        resultServer.setCode(200);
	        resultServer.setMessage("查找成功");
	        resultServer.setData(user);
        }else {
        	resultServer.setCode(400);
 	        resultServer.setMessage("您输入的id有误");
		}
        return resultServer;
    }
    
    //根据名字查找用户
    @Override
    public ResultServer<Integer> findByName(String name) {
    	ResultServer<Integer> resultServer = new ResultServer<Integer>();
    	User user=userDao.findByName(name);
    	if(user!=null) {
	        resultServer.setCode(200);
	        resultServer.setMessage("查找成功");
	        resultServer.setData(user);
        }else {
        	resultServer.setCode(400);
 	        resultServer.setMessage("您输入的name有误");
		}
    	return resultServer;
    }
    
    //查询所有用户
   @Override
   public ResultServer<Integer> findAllUser(){
	   List<User> list = userDao.findAllUser();
	   ResultServer<Integer> resultServer = new ResultServer<Integer>();
	   resultServer.setCode(200);
	   resultServer.setMessage("所有用户信息");
	   resultServer.setData(list);
	   return resultServer;
   }
    
    //根据id删除用户
    @Override
    public ResultServer<Integer> deleteById(int id){
    	ResultServer<Integer> resultServer = new ResultServer<Integer>();
    	User user=userDao.findById(id);
        if(user!=null) {
        	 userDao.deleteById(id);
             resultServer.setCode(200);
             resultServer.setMessage("删除成功");
             resultServer.setData(user);
        }else {
        	resultServer.setCode(400);
 	        resultServer.setMessage("您输入的id有误");
		}
        return resultServer;
    }
}
