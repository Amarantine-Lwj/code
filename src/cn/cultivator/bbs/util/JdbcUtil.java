package cn.cultivator.bbs.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
}
