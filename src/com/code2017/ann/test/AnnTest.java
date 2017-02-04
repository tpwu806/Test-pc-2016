package com.code2017.ann.test;

import org.junit.Test;

public class AnnTest {

	@Test
	public void annTest(){
		RoleContext.INSTANCE.setCurrentRole(Role.SYSTEM);
		UserDao dao = DaoProxyFactory.newRoleDaoProxy(UserDao.class);
		dao.delete();
		
	}
}
