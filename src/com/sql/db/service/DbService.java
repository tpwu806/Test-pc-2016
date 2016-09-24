package com.sql.db.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sql.db.core.MyConnection;
import com.sql.db.service.base.ADbServiceBase;
import com.sql.db.service.base.IDbServiceBase;


/**
 * @Title: DbHelper.java
 * @Description: 统一查询类 。预编译，通过?赋值方式可以防止漏洞注入方式，保证安全性。
 * @author wutp
 * @version 1.0
 * @time 2016-8-17下午4:37:39
 */
public class DbService extends ADbServiceBase implements IDbService{    
	
	public DbService()throws Exception{
		super(1);
	}
	
	public DbService(int dataBaseId)throws Exception{
		super(dataBaseId);
	}

}
