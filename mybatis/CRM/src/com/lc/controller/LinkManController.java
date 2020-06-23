package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.LinkMan;
import com.lc.entity.SaleChance;
import com.lc.service.LinkManService;
import com.lc.service.SaleChanceService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/linkMan")
public class LinkManController {
	@Resource
	public LinkManService linkManService;
	
	/**
	 * ��ѯ�ͻ������ƻ�����
	 * @param page
	 * @param rows
	 * @param s_linkMan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="cusId",required=false) String cusId,HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId);
		//��ѯ�ͻ������ƻ�����
		List<LinkMan> linkManList = linkManService.find(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//���˵�����Ҫ������
		jsonConfig.setExcludes(new String[]{"customer"});
		//��linkManList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(linkManList,jsonConfig);
		json.put("rows", jsonArray);
		ResponseUtil.write(response, json);
		return null;
	}
	
	
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param linkMan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(LinkMan linkMan,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (linkMan.getId()==null) {
			resultTotal = linkManService.add(linkMan);
		} else {
			resultTotal = linkManService.update(linkMan);
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
		linkManService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
