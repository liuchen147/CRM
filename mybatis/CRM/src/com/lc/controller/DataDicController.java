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
	 * 查询数据字典方法
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
		map.put("size", pageBean.getPageSize());		//从pageBean里面取出每页显示的记录个数
		//查询数据字典集合
		List<DataDic> dataDicList = dataDicService.find(map);
		//获取数据字典总记录数
		Long total = dataDicService.getTotal(map);
		JSONObject json = new JSONObject();
		//将dataDicList集合转换为json格式的数组
		JSONArray jsonArray = JSONArray.fromObject(dataDicList);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	
	/**
	 * 查询所有的数据字典名称
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findDataDicName")
	public String findDataDicName(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = new JSONArray();
		List<DataDic> dataDicList = dataDicService.findAll();
		//把集合转变为json格式的数组
		JSONArray rows = JSONArray.fromObject(dataDicList);
		jsonArray.addAll(rows);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
	
	/**
	 * 预处理，判断是添加还是修改以及是否成功
	 * @param dataDic
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(DataDic dataDic,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//操作的记录数
		/**
		 * 判断是添加还是修改
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
	 * 数据字典删除
	 * 多选删除，选择多个选项再一起删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false) String ids, HttpServletResponse response) throws Exception {
		String idsStr[] = ids.split(",");	//按指定的符号分割字符串，变为数组[1,2,3]
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
