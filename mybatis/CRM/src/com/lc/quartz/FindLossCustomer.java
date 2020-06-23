package com.lc.quartz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lc.service.CustomerService;

@Component
public class FindLossCustomer {

	@Resource
	private CustomerService customerService;
	
	@Scheduled(cron="0 0/1 * * * ?")
	public void work() {
		customerService.checkCustomerLoss();
	}
}
