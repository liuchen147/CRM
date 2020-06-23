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

import com.lc.entity.CustomerService;
import com.lc.entity.CustomerService;
import com.lc.entity.PageBean;
import com.lc.entity.SaleChance;
import com.lc.service.CustomerServiceService;
import com.lc.service.SaleChanceService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * �ͻ�����Controller��
 * @author ��
 *
 */
@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:���������ֵ��false:����Ϊ��ֵ
	}
	
	@Resource
	public CustomerServiceService customerServiceService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,CustomerService s_customerService,String createTimeFrom,String createTimeTo,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer", StringUtil.formatLike(s_customerService.getCustomer()));
		map.put("overview", StringUtil.formatLike(s_customerService.getOverview()));
		map.put("serveType", s_customerService.getServeType());
		map.put("createTimeFrom", createTimeFrom);
		map.put("createTimeTo", createTimeTo);
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ���ۻ��Ἧ��
		List<CustomerService> customerServiceList = customerServiceService.find(map);
		//��ȡ���ۻ����ܼ�¼��
		Long total = customerServiceService.getTotal(map);
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject json = new JSONObject();
		//��customerServiceList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(customerServiceList,jsonConfig);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param customerService
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(CustomerService customerService,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (customerService.getId()==null) {
			//customerService.setState("�´���");
			resultTotal = customerServiceService.add(customerService);
			
		} else {
			resultTotal = customerServiceService.update(customerService);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.accumulate("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
}
