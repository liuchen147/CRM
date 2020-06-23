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

import com.lc.entity.Contact;
import com.lc.service.ContactService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:���������ֵ��false:����Ϊ��ֵ
	}
	
	@Resource
	public ContactService contactService;
	
	/**
	 * ��ѯ�ͻ������ƻ�����
	 * @param page
	 * @param rows
	 * @param s_contact
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="cusId",required=false) String cusId,HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId);
		//��ѯ�ͻ������ƻ�����
		List<Contact> contactList = contactService.find(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.setExcludes(new String[]{"customer"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		//��contactList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(contactList,jsonConfig);
		json.put("rows", jsonArray);
		ResponseUtil.write(response, json);
		return null;
	}
	
	
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param contact
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(Contact contact,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (contact.getId()==null) {
			resultTotal = contactService.add(contact);
		} else {
			resultTotal = contactService.update(contact);
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
	 * �ͻ������ƻ�ɾ��
	 * ��ѡɾ����ѡ����ѡ����һ��ɾ��
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		contactService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
