package cn.cultivator.bbs.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.cultivator.bbs.domain.Admin;
import cn.cultivator.bbs.domain.Topic;
import cn.cultivator.bbs.domain.Type;
import cn.cultivator.bbs.util.JdbcUtil;

public class TypeDao {
	public List<Type> findAllType() throws Exception{
		List<Type> typeList = new ArrayList<Type>();
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "SELECT * FROM type";
		typeList = runner.query(sql,new BeanListHandler<Type>(Type.class));
		return typeList;
	}
	public int findTopicNum(Integer typeId) throws Exception{
		int intVal = 0;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select count(*) from topic where type_id = ? ";
		Object[] params = {typeId};
		Long temp = (Long) runner.query(sql,new ScalarHandler(),params);
		intVal = temp.intValue();
		return intVal;
	}
	public Admin findAdminById(Integer id) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from admin where id = ?";
		Object[] params = {id};
		Admin admin = runner.query(sql, new BeanHandler<Admin>(Admin.class),params);
		return admin;
	}
	public Topic findNewTopicById(Integer typeId) throws Exception{
		Topic newTopic = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from topic where type_id = ? order by time desc";
		Object[] params = {typeId};
		newTopic = runner.query(sql, new BeanHandler<Topic>(Topic.class),params);
		return newTopic;
	}
	public List<Topic> listAllTopic(Integer typeId) throws Exception{
		List<Topic> topicList = new ArrayList<Topic>();
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "SELECT * FROM topic WHERE type_id = ? ORDER BY time DESC";
		Object[] params = {typeId};
		topicList = runner.query(sql, new BeanListHandler<Topic>(Topic.class),params);
		return topicList;
	}
	public void AddclickNum(Integer typeId) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "update type set click = click + 1 where id = ?";
		Object[] params = {typeId};
		runner.update(sql, params);
	}
	public void addTopic(Topic topic) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into topic(name,author,content,type_id) values(?,?,?,?)";
		Object[] params = {topic.getName(),topic.getAuthor(),topic.getContent(),topic.getTypeId()};
		runner.update(sql, params);
	}
	
}
