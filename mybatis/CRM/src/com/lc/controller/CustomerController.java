package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.Customer;
import com.lc.entity.CustomerFw;
import com.lc.entity.CustomerGc;
import com.lc.entity.CustomerGx;
import com.lc.entity.PageBean;
import com.lc.service.CustomerService;
import com.lc.util.DateUtil;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	public CustomerService customerService;
	
	/**
	 * ��ѯ����
	 * @param page
	 * @param rows
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,Customer s_customer,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("khno", StringUtil.formatLike(s_customer.getKhno()));
		map.put("name", StringUtil.formatLike( s_customer.getName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());		//��pageBean����ȡ��ÿҳ��ʾ�ļ�¼����
		//��ѯ�����ֵ伯��
		List<Customer> customerList = customerService.find(map);
		//��ȡ�����ֵ��ܼ�¼��
		Long total = customerService.getTotal(map);
		JSONObject json = new JSONObject();
		//��customerList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(customerList);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param customer
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(Customer customer,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (customer.getId()==null) {
			//�ѵ�ǰʱ�丳���ͻ����
			customer.setKhno("KH"+DateUtil.getCurrentDateStr());
			resultTotal = customerService.add(customer);
		} else {
			resultTotal = customerService.update(customer);
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
	/**
	 * ɾ��
	 * ��ѡɾ����ѡ����ѡ����һ��ɾ��
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false) String ids, HttpServletResponse response) throws Exception {
		String idsStr[] = ids.split(",");	//��ָ���ķ��ŷָ��ַ�������Ϊ����[1,2,3]
		for (int i = 0; i < idsStr.length; i++) {
			customerService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		Customer customer = customerService.findById(Integer.parseInt(id));
		JSONObject jsonObject = JSONObject.fromObject(customer);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	/**
	 * ��ҳ������ѯ�ͻ�����
	 * @param page
	 * @param rows
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGx")
	public String findCustomerGx(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,String name,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", StringUtil.formatLike(name));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());		//��pageBean����ȡ��ÿҳ��ʾ�ļ�¼����
		//��ѯ�����ֵ伯��
		List<CustomerGx> customerGxList = customerService.findCustomerGx(map);
		//��ȡ�����ֵ��ܼ�¼��
		Long total = customerService.getTotalCustomerGx(map);
		JSONObject json = new JSONObject();
		//��customerList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(customerGxList);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	/**
	 * �ͻ����ɷ�����ѯ
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findCustomerGc")
	public String findCustomerGc(HttpServletResponse response) throws Exception {
		List<CustomerGc> customerGcList = customerService.findCustomerGc();
		JSONArray jsonArray = JSONArray.fromObject(customerGcList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * �ͻ����������ѯ
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findCustomerFw")
	public String findCustomerFw(HttpServletResponse response) throws Exception {
		List<CustomerFw> customerFwList = customerService.findCustomerFw();
		JSONArray jsonArray = JSONArray.fromObject(customerFwList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
}
