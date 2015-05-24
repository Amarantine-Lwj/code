package cn.cultivator.bbs.service;

import java.util.List;

import cn.cultivator.bbs.dao.AddressDao;
import cn.cultivator.bbs.dao.TypeDao;
import cn.cultivator.bbs.dao.UserDao;
import cn.cultivator.bbs.domain.Address;
import cn.cultivator.bbs.domain.Admin;
import cn.cultivator.bbs.domain.Topic;
import cn.cultivator.bbs.domain.Type;
import cn.cultivator.bbs.domain.User;
import cn.cultivator.bbs.exception.UserNameExistException;
import cn.cultivator.bbs.util.WebUtil;

public class BbsService {
	private TypeDao typeDao = new TypeDao();
	private UserDao userDao = new UserDao();
	private AddressDao addressDao = new AddressDao();
	public List<Type> listAllType() throws Exception{
		try {
			List<Type> typeList = typeDao.findAllType();
			for(Type type:typeList){
				Admin admin = typeDao.findAdminById(type.getAdmin_id());
				type.setAdmin(admin);
				Integer topicNum = typeDao.findTopicNum(type.getId());
				type.setTopicNum(topicNum);
				Topic newTopic = typeDao.findNewTopicById(type.getId());
				type.setNewTopic(newTopic);
			}
			return typeList;
		} catch (Exception e) {
			//写日志
			throw e;
		}
	}
	public User login(User user) throws Exception{
		String passwordMD5 = WebUtil.encodeByMd5(user.getPassword());
		user.setPassword(passwordMD5);
		return userDao.login(user);
	}
	
	public void register(User user) throws Exception {
		try {
			Boolean flag = userDao.isExist(user.getUsername());
			if(!flag){
				String passwordMD5 = WebUtil.encodeByMd5(user.getPassword());
				user.setPassword(passwordMD5);
				userDao.register(user);	
			}else {
				throw new UserNameExistException();
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Topic> listAllTopic(Integer typeId) throws Exception{
		return typeDao.listAllTopic(typeId);
	}
	
	public void updateClickNum(Integer typeId) throws Exception{
		typeDao.AddclickNum(typeId);
		
	}
	public void addTopic(Topic topic) throws Exception{
		if(topic == null){
			throw new Exception();
		}
		try {
			typeDao.addTopic(topic);
		} catch (Exception e) {
			//写日志
			throw e;
		}
	
	}
	
	public Address getAddress(String ip) throws Exception{
		Address address;
		try {
			address = addressDao.getAddress(ip);
			if(address==null){
				address = new Address();
				address.setIp("127.0.0.1");
				address.setLocation("梅州");
			}
			return address;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}

	}
	
}
