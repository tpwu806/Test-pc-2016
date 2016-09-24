package com.sql.main;

import com.sql.db.service.DbService;
import com.sql.db.service.base.IDbServiceBase;

public class DBTestMainDemo {
	private static IDbServiceBase dbService = null;
	public static void main(String[] args) {
		String sql = "";
		String[] params = null;
		try {
			sql="SELECT * FROM test WHERE NAME = 'admin' "
					+" AND PASSWORD = '123456'";
			params = new String[2];
			params[0] = "admin";
			params[1] = "123456";
			dbService = new DbService();
			boolean b = dbService.execute(sql, params);
			System.out.println("登录：" + b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
