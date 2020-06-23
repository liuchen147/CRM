package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.OrderDetails;
import com.lc.entity.PageBean;
import com.lc.service.OrderDetailsService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/orderDetails")
public class OrderDetailsController {
	
	
	@Resource
	public OrderDetailsService orderDetailsService;
	/**
	 * ��ѯ���ۻ��᷽��
	 * @param page
	 * @param rows
	 * @param s_orderDetails
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,@RequestParam(value="orderId",required=false) String orderId,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId",orderId);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ���ۻ��Ἧ��
		List<OrderDetails> orderDetailsList = orderDetailsService.find(map);
		//��ȡ���ۻ����ܼ�¼��
		Long total = orderDetailsService.getTotal(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.setExcludes(new String[]{"order"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		//��orderDetailsList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(orderDetailsList,jsonConfig);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	@RequestMapping("/getTotalPrice")
	public String getTotalPrice(@RequestParam(value="orderId",required=false) String orderId,HttpServletResponse response) throws Exception{
		float totalMoney = orderDetailsService.getTotalPriceByOrderId(Integer.parseInt(orderId));
		JSONObject json = new JSONObject();
		json.put("totalMoney", totalMoney);
		ResponseUtil.write(response, json);
		return null;
	}
}
