package com.lc.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.CustomerLoss;

import com.lc.entity.PageBean;
import com.lc.service.CustomerLossService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {
	
	@Resource
	public CustomerLossService customerLossService;
	/**
	 * ��ѯ���ۻ��᷽��
	 * @param page
	 * @param rows
	 * @param s_customerLoss
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,CustomerLoss s_CustomerLoss,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusName", StringUtil.formatLike(s_CustomerLoss.getCusName()));
		map.put("cusManager", StringUtil.formatLike(s_CustomerLoss.getCusManager()));
		map.put("state", s_CustomerLoss.getState());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ���ۻ��Ἧ��
		List<CustomerLoss> customerLossList = customerLossService.find(map);
		//��ȡ���ۻ����ܼ�¼��
		Long total = customerLossService.getTotal(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		//��customerLossList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(customerLossList,jsonConfig);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	
	@RequestMapping("/confirmLoss")
	public String confirmlLoss(int id,String lossReason,HttpServletResponse response) throws Exception{
		CustomerLoss customerLoss = new CustomerLoss();
		customerLoss.setId(id);
		customerLoss.setConfirmLossTime(new Date());
		customerLoss.setState(1);
		customerLoss.setLossReason(lossReason);
		//��ʼ�޸� ȷ����ʧʱ�� ״̬����ʧԭ��
		customerLossService.update(customerLoss);
		JSONObject result= new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		CustomerLoss customerLoss = customerLossService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(customerLoss,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
}
