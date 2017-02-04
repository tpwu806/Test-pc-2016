package com.code2017.ann.test;

public enum RoleContext {

	INSTANCE;	

	private ThreadLocal<Role> role = new ThreadLocal<Role>();	

	public Role getCurrentRole() {
		return role.get();
	}
	
	public void setCurrentRole(Role role) {
		this.role.set(role);
	}

}
