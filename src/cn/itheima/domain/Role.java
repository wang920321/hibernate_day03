/**  

* Title: Role.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年3月22日  

* @version 1.0  

*/
package cn.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**  

* Title: Role  

* Description:   

* @author 172219902  

* @date 2018年3月22日  

*/
public class Role {
	/*
	 * 
	  CREATE TABLE `sys_role` (
  `role_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_memo` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
	 */
	private Long role_id;
	private String role_name;
	private String role_memo;
	//多对多
	private Set<User> users=new HashSet<User>();
	
	/**
	 * @return the role_id
	 */
	public Long getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**
	 * @return the role_memo
	 */
	public String getRole_memo() {
		return role_memo;
	}
	/**
	 * @param role_memo the role_memo to set
	 */
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
