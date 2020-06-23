package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.DataDic;
import com.lc.entity.PageBean;
import com.lc.service.DataDicService;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dataDic")
public class DataDicController {

	@Resource
	public DataDicService dataDicService;
	
	/**
	 * ��ѯ�����ֵ䷽��
	 * @param page
	 * @param rows
	 * @param s_dataDic
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,DataDic s_dataDic,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dataDicName", s_dataDic.getDataDicName());
		map.put("dataDicValue", StringUtil.formatLike( s_dataDic.getDataDicValue()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());		//��pageBean����ȡ��ÿҳ��ʾ�ļ�¼����
		//��ѯ�����ֵ伯��
		List<DataDic> dataDicList = dataDicService.find(map);
		//��ȡ�����ֵ��ܼ�¼��
		Long total = dataDicService.getTotal(map);
		JSONObject json = new JSONObject();
		//��dataDicList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	/**
	 * ��ѯ���е������ֵ�����
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findDataDicName")
	public String findDataDicName(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		List<DataDic> dataDicList = dataDicService.findAll();
		//�Ѽ���ת��Ϊjson��ʽ������
		JSONArray rows = JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * Ԥ�����ж�����ӻ����޸��Լ��Ƿ�ɹ�
	 * @param dataDic
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(DataDic dataDic,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//�����ļ�¼��
		/**
		 * �ж�����ӻ����޸�
		 */
		if (dataDic.getId()==null) {
			resultTotal = dataDicService.add(dataDic);
		} else {
			resultTotal = dataDicService.update(dataDic);
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
	 * �����ֵ�ɾ��
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
			dataDicService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/dataDicComboList")
	public String dataDicComboList(@RequestParam(value="dataDicName",required=false) String dataDicName, HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("dataDicName", dataDicName);
		List<DataDic> dataDicList = dataDicService.find(map);
		JSONArray rows = JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
}
