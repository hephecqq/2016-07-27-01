package com.net;

import org.springframework.stereotype.Component;

public class JavaNetClass {

	private String className;
	
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName(){
		return JavaNetClass.class.getName();
	}
}
