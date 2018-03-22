/**  

* Title: Demo.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年3月21日  

* @version 1.0  

*/
package cn.itheima.a_one2many;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.domain.LinkMan;
import cn.itheima.utils.HibernateUtils;

/**  

* Title: Demo  

* Description:    级联操作

* @author 172219902  

* @date 2018年3月21日  

*/
public class Demo2 {
	@Test
	
    public  void fun1(){
		//1获得session\
		Session session = HibernateUtils.openSession();
		//2开启事务
		Transaction tx = session.beginTransaction();
		//3操作
		//-------------------------------------------
		Customer customer=new Customer();
		customer.setCust_name("传智播客");
		LinkMan lm1=new LinkMan();
		lm1.setLkm_name("zhangsan");
		LinkMan lm2=new LinkMan();
		lm2.setLkm_name("lisa");
		LinkMan lm3=new LinkMan();
		lm3.setLkm_name("wangdage");
		
		//一对多,客户下有多个联系人
		customer.getLinkMans().add(lm1);
		customer.getLinkMans().add(lm2);
		customer.getLinkMans().add(lm3);
		
		//表达多对一,联系人属于哪个客户
		lm1.setCustomer(customer);
		lm2.setCustomer(customer);
		lm3.setCustomer(customer);
		
		session.save(customer);
		
		//---------------------------------------------
		
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
@Test
	//测试删除客户是，级联删除客户下的联系人
    public  void fun2(){
		//1获得session\
		Session session = HibernateUtils.openSession();
		//2开启事务
		Transaction tx = session.beginTransaction();
		//3操作
		//-------------------------------------------
		Customer customer = session.get(Customer.class, 1L);
		session.delete(customer);
		//---------------------------------------------
		
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
    @Test
   public  void fun3(){
	//1获得session\
	Session session = HibernateUtils.openSession();
	//2开启事务
	Transaction tx = session.beginTransaction();
	//3操作
	//-------------------------------------------
	Customer customer = session.get(Customer.class, 2L);
	
	LinkMan lm = session.get(LinkMan.class, 6L);
	
	customer.getLinkMans().remove(lm);
	lm.setCustomer(null);
	//---------------------------------------------
	
	//4提交事务
	tx.commit();
	//5关闭资源
	session.close();
}
	@Test
	//保存联系人及联系人对应的客户
    public  void fun4(){
		//1获得session\
		Session session = HibernateUtils.openSession();
		//2开启事务
		Transaction tx = session.beginTransaction();
		//3操作
		//-------------------------------------------
		Customer customer=new Customer();
		customer.setCust_name("Alibaba");
		LinkMan lm1=new LinkMan();
		lm1.setLkm_name("zhangsan");
		LinkMan lm2=new LinkMan();
		
		
		//一对多,客户下有多个联系人
		customer.getLinkMans().add(lm1);
		
		
		//表达多对一,联系人属于哪个客户
		lm1.setCustomer(customer);
		
		
		session.save(lm1);
		
		//---------------------------------------------
		
		//4提交事务
		tx.commit();
		//5关闭资源
		session.close();
	}
	
}
