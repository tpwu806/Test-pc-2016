package com.jdbc.main;

import com.jdbc.data.service.DbService;
import com.jdbc.data.service.base.IDbServiceBase;

public class DBTestMainDemo {
	private static IDbServiceBase dbService = null;
	public static void main(String[] args) {
		String sql = "";
		String[] params = null;
		try {
			sql="SELECT COUNT(*) FROM test WHERE NAME = ? "
					+" AND PASSWORD = ?";
			params = new String[2];
			params[0] = "admin";
			params[1] = "123456";
			dbService = new DbService();
			boolean b = dbService.executeQuery(sql, params);
			System.out.println("登录：" + b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
