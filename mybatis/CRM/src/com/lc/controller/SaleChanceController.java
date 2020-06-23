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

import com.lc.entity.PageBean;
import com.lc.entity.SaleChance;
import com.lc.service.SaleChanceService;
import com.lc.util.DateJsonValueProcessor;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {

	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
	
	@Resource
	public SaleChanceService saleChanceService;
	/**
	 * 查询销售机会方法
	 * @param page
	 * @param rows
	 * @param s_saleChance
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,SaleChance s_saleChance,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customerName", StringUtil.formatLike( s_saleChance.getCustomerName()));
		map.put("overView", StringUtil.formatLike( s_saleChance.getOverView()));
		map.put("createMan", StringUtil.formatLike( s_saleChance.getCreateMan()));
		map.put("state", s_saleChance.getState());
		map.put("devResult", s_saleChance.getDevResult());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//查询销售机会集合
		List<SaleChance> saleChanceList = saleChanceService.find(map);
		//获取销售机会总记录数
		Long total = saleChanceService.getTotal(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		//将saleChanceList集合转换为json格式的数组
		JSONArray jsonArray = JSONArray.fromObject(saleChanceList,jsonConfig);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
	/**
	 * 预处理，判断是添加还是修改以及是否成功
	 * @param saleChance
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(SaleChance saleChance,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//操作的记录数
		//如果指派人不为空，则表示已分配，设置为1
		if (StringUtil.isNotEmpty(saleChance.getAssignMan())) {
			saleChance.setState(1);
		} else {
			saleChance.setState(0);
		}
		/**
		 * 判断是添加还是修改
		 */
		if (saleChance.getId()==null) {
			//添加的时候，开发状态默认为0
			resultTotal = saleChanceService.add(saleChance);
		} else {
			resultTotal = saleChanceService.update(saleChance);
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
	 * 销售机会删除
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
			saleChanceService.delete(Integer.parseInt(idsStr[i]));
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 通过Id查看销售机会的详细信息
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		SaleChance saleChance = saleChanceService.findById(Integer.parseInt(id));
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		
		JSONObject jsonObject = JSONObject.fromObject(saleChance, jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
