package com.senla.task8.service;

import java.io.Serializable;

public class DataMethod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454979231825570732L;
	private String methodName;
	private Object [] args;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
}
