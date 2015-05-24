package cn.cultivator.bbs.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.cultivator.bbs.domain.User;
import cn.cultivator.bbs.util.JdbcUtil;

public class UserDao {
	//登录
	public User login(User user) throws Exception{
		User user2 = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql ="select * from user where username = ? and password = ?";
		Object[] param = {user.getUsername(),user.getPassword()};
		user2 = runner.query(sql, param, new BeanHandler<User>(User.class));
		return user2;
	}
	//注册
	public void register(User user) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into user(username,password,gender,email) values(?,?,?,?)";
		Object[] param = {user.getUsername(),user.getPassword(),user.getGender(),user.getEmail()};
		runner.update(sql, param);
	}
	
	@SuppressWarnings("deprecation")
	public Boolean isExist(String username) throws SQLException{
		Boolean flag = false;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user where username = ?";
		Object[] params = {username};
		User user2 = runner.query(sql, params,new BeanHandler<User>(User.class));
		if(user2!=null){
			flag = true;
		}
		return flag;
	}
	
}
