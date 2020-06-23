package com.lc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lc.dao.CustomerDao;
import com.lc.dao.CustomerLossDao;
import com.lc.dao.OrderDao;
import com.lc.entity.Customer;
import com.lc.entity.CustomerFw;
import com.lc.entity.CustomerGc;
import com.lc.entity.CustomerGx;
import com.lc.entity.CustomerLoss;
import com.lc.entity.Order;
import com.lc.service.CustomerService;

@Service("customer")
public class CustomerServiceImpl implements CustomerService{
		@Resource
		private CustomerDao customerDao;
		
		@Resource
		private OrderDao orderDao;
		
		@Resource
		private CustomerLossDao customerLossDao;
		
		public List<Customer> find(Map<String, Object> map) {
			return customerDao.find(map);
		}

		public Long getTotal(Map<String, Object> map) {
			return customerDao.getTotal(map);
		}

		public int add(Customer customer) {
			return customerDao.add(customer);
		}

		public int update(Customer customer) {
			return customerDao.update(customer);
		}

		public int delete(Integer id) {
			return customerDao.delete(id);
		}

		public Customer findById(Integer id) {
			return customerDao.findById(id);
		}

		public void checkCustomerLoss() {
			//查找流失客户
			List<Customer> customerLossList = customerDao.findLossCustomer();
			for (Customer c : customerLossList) {
				//实例化客户流失对象
				CustomerLoss customerLoss = new CustomerLoss();
				customerLoss.setCusNo(c.getKhno());		//客户编号
				customerLoss.setCusName(c.getName());	//客户名称
				customerLoss.setCusManager(c.getCusManager());//客户经理
				Order order = orderDao.findLastOrderByCusId(c.getId());//获取指定客户的最近一笔订单
				if (order == null) {
					customerLoss.setLastOrderTime(null);
				} else {
					customerLoss.setLastOrderTime(order.getOrderDate());
				}
				//开始把流失客户添加到客户流失表里面去
				customerLossDao.add(customerLoss);
				//客户状态改成1，即为流失状态
				c.setState(1);
				customerDao.update(c);
			}
		}

		@Override
		public List<CustomerGx> findCustomerGx(Map<String, Object> map) {
			
			return customerDao.findCustomerGx(map);
		}

		@Override
		public Long getTotalCustomerGx(Map<String, Object> map) {
			return customerDao.getTotalCustomerGx(map);
		}

		@Override
		public List<CustomerGc> findCustomerGc() {
			
			return customerDao.findCustomerGc();
		}

		@Override
		public List<CustomerFw> findCustomerFw() {
			
			return customerDao.findCustomerFw();
		}


}
