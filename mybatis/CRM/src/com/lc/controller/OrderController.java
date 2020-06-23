package com.lc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.Order;
import com.lc.entity.PageBean;
import com.lc.service.OrderService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:���������ֵ��false:����Ϊ��ֵ
	}
	
	@Resource
	public OrderService orderService;
	/**
	 * ��ѯ���ۻ��᷽��
	 * @param page
	 * @param rows
	 * @param s_order
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,@RequestParam(value="cusId",required=false) String cusId,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId",cusId);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ���ۻ��Ἧ��
		List<Order> orderList = orderService.find(map);
		//��ȡ���ۻ����ܼ�¼��
		Long total = orderService.getTotal(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.setExcludes(new String[]{"customer"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		//��orderList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(orderList,jsonConfig);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		Order order = orderService.findById(Integer.parseInt(id));
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.setExcludes(new String[]{"order"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(order,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
