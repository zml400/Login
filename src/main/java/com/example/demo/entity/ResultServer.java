package com.example.demo.entity;

import java.io.Serializable;

public class ResultServer<T> implements Serializable {
	private T code;      //状态码
	private String message;   //信息
	private Object data;      //数据对象
	
	public T getCode() {
		return code;
	}
	public void setCode(T code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
