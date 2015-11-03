package cn.imust.service.impl;

import cn.imust.dao.CustomerDao;
import cn.imust.dao.impl.CustomerDaoImpl;
import cn.imust.domain.Customer;
import cn.imust.service.CustomerService;
import cn.imust.utils.Md5Utils;

public class CustomerServiceImpl implements CustomerService {

	//业务逻辑层依赖于数据访问层
	private CustomerDao customerDao = new CustomerDaoImpl();//多态，面向接口编程  
	
	public Customer login(String username, String password) {
		//在业务逻辑层中放入加密的操作
		password = Md5Utils.encode(password);
		return customerDao.findCustomerByUsernameAndPwd(username, password);
	}

	//更新
	public void update(Customer customer) {
		customer.setPassword(Md5Utils.encode(customer.getPassword()));//===========要注意
		customerDao.update(customer);
	}

	public void regist(Customer customer) {
		customer.setPassword(Md5Utils.encode(customer.getPassword()));//===========要注意
        customerDao.save(customer);		
	}

}
