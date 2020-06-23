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

import com.lc.entity.CusDevPlan;
import com.lc.entity.SaleChance;
import com.lc.service.CusDevPlanService;
import com.lc.service.SaleChanceService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {

	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:���������ֵ��false:����Ϊ��ֵ
	}
	
	@Resource
	public CusDevPlanService cusDevPlanService;
	
	
	@Resource
	public SaleChanceService saleChanceService;
	/**
	 * ��ѯ�ͻ������ƻ�����
	 * @param page
	 * @param rows
	 * @param s_cusDevPlan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="saleChanceId",required=false) String saleChanceId,HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saleChanceId", saleChanceId);
		//��ѯ�ͻ������ƻ�����
		List<CusDevPlan> cusDevPlanList = cusDevPlanService.find(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"saleChance"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		//��cusDevPlanList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(cusDevPlanList,jsonConfig);
		json.put("rows", jsonArray);
		ResponseUtil.write(response, json);
		return null;
	}
	
	
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param cusDevPlan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(CusDevPlan cusDevPlan,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (cusDevPlan.getId()==null) {
			resultTotal = cusDevPlanService.add(cusDevPlan);
			SaleChance saleChance = new SaleChance();
			saleChance.setId(cusDevPlan.getSaleChance().getId());
			//�������һ�������ƻ�ʱ���ı䵱ǰ�����ۻ���Ŀ���״̬���ĳɿ����У�1��
			saleChance.setDevResult(1);
			saleChanceService.update(saleChance);
			resultTotal = cusDevPlanService.add(cusDevPlan);
		} else {
			resultTotal = cusDevPlanService.update(cusDevPlan);
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
		cusDevPlanService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * �޸Ŀͻ�����״̬��2�ǿ����ɹ���3�ǿ���ʧ��
	 * @param cusDevPlan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updateSaleChanceDevResult")
	public String updateSaleChanceDevResult(@RequestParam(value="id",required=false) String id,@RequestParam(value="devResult",required=false) String devResult,HttpServletResponse response) throws Exception {
		SaleChance saleChance = new SaleChance();
		saleChance.setId(Integer.parseInt(id));
		saleChance.setDevResult(Integer.parseInt(devResult));
		int resultTotal = saleChanceService.update(saleChance);
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
