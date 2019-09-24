package com.base.ann.test;

@Implement(UserDaoImpl.class)
public interface UserDao extends BaseDao {

	@Permission({Role.ADMINISTRATOR, Role.SYSTEM})
	void save();

	@Permission(Role.SYSTEM)
	void delete();

	@Permission({Role.USER, Role.ADMINISTRATOR, Role.SYSTEM})
	void query();
}
