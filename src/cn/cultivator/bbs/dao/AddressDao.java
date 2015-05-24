package cn.cultivator.bbs.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.cultivator.bbs.domain.Address;
import cn.cultivator.bbs.util.JdbcUtil;

public class AddressDao {
	public Address getAddress(String ip) throws Exception{
		Address address = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from address where ip=?";
		Object[] param = {ip};
		address = runner.query(sql,new BeanHandler<Address>(Address.class),param);
		return address;
	}
}
