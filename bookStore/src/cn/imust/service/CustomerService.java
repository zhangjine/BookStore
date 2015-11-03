package cn.imust.service;

import cn.imust.domain.Customer;

/**
 * Customer对应的业务逻辑
 * @author yang
 *
 */
public interface CustomerService {

	/**'
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Customer login(String username,String password);

	/**
	 * 更新用户信息
	 * @param customer
	 */
	public void update(Customer customer);

	/**
	 * 注册 
	 * @param customer
	 */
	public void regist(Customer customer);
}
