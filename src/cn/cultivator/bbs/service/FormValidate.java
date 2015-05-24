package cn.cultivator.bbs.service;

import java.util.HashMap;
import java.util.Map;

import cn.cultivator.bbs.domain.User;


public class FormValidate {

	private String username;
	private String email;
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	Map<String,String> errors = new HashMap<String, String>();
	
	public Boolean validate(User user){
		Boolean flag = false;
		username = user.getUsername();
		String password = user.getPassword();
		email = user.getEmail();
		if(this.validateUserName(username)&&
				this.validatePassword(password)&&
				this.validateEmail(email)){
			flag = true;
		}
		return flag;
	}
	
	private Boolean validateUserName(String username){
		Boolean flag = false;
		if(username!=null && username.trim().length()>0){
			if(username.matches("[\u4E00-\uFA29]+")){
				flag = true;
			}else{
				this.errors.put("username", "Your usernaem is false~");
			}
		}else{
			this.errors.put("username", "Your usernaem is false~");
		}
		return flag;
	}
	
	private Boolean validatePassword(String password){
		Boolean flag = false;
		if(password!=null && username.trim().length()>0){
			if(password.matches("[0-9]{6}")){
				flag = true;
			}else{
				this.errors.put("password", "Your password is false");
			}
		}else{
			this.errors.put("password", "Your password is false~");
		}
		return flag;
		
	}
	private boolean validateEmail(String email){
		boolean flag = false;
		if(email!=null && email.trim().length()>0){
			if(email.matches("\\w+@\\w+(\\.\\w+)+")){
				flag = true;
			}else{
				this.errors.put("email","Your email is false");
			}
		}else{
			this.errors.put("email","Your email is false");
		}
		return flag;
	}
}
