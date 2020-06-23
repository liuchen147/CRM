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
	 * 查询客户开发计划方法
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
		//查询客户开发计划集合
		List<LinkMan> linkManList = linkManService.find(map);
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		//过滤掉不需要的属性
		jsonConfig.setExcludes(new String[]{"customer"});
		//将linkManList集合转换为json格式的数组
		JSONArray jsonArray = JSONArray.fromObject(linkManList,jsonConfig);
		json.put("rows", jsonArray);
		ResponseUtil.write(response, json);
		return null;
	}
	
	
	/**
	 * 预处理，判断是添加还是修改以及是否成功
	 * @param linkMan
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(LinkMan linkMan,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//操作的记录数
		/**
		 * 判断是添加还是修改
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
	 * 客户开发计划删除
	 * 多选删除，选择多个选项再一起删除
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
