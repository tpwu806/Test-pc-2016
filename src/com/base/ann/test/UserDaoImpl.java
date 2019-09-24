package com.base.ann.test;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserDaoImpl.save()");
	}

	@Override
	public void delete() {
		System.out.println("UserDaoImpl.delete()");
	}

	@Override
	public void query() {
		System.out.println("UserDaoImpl.query()");
	}

}
