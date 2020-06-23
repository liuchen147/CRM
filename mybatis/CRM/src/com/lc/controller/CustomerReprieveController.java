package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.CustomerReprieve;
import com.lc.entity.PageBean;
import com.lc.service.CustomerReprieveService;
import com.lc.util.DateUtil;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/customerReprieve")
public class CustomerReprieveController {

	@Resource
	public CustomerReprieveService customerReprieveService;
	
	/**
	 * 查询数据字典方法
	 * @param page
	 * @param rows
	 * @param s_customerReprieve
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="lossId",required=false) String lossId,@RequestParam(value="rows",required=false) String rows,HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lossId", lossId);
		
		List<CustomerReprieve> customerReprieveList = customerReprieveService.find(map);
	
		JSONObject json = new JSONObject();
		JsonConfig jsonConfig =new JsonConfig();
		jsonConfig.setExcludes(new String[] {"customerloss"});
		//将customerReprieveList集合转换为json格式的数组
		JSONArray jsonArray = JSONArray.fromObject(customerReprieveList);
		json.put("rows", jsonArray);
		
		ResponseUtil.write(response, json);
		return null;
	}
	
	/**
	 * 预处理，判断是添加还是修改以及是否成功
	 * @param customerReprieve
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public String save(CustomerReprieve customerReprieve,HttpServletResponse response) throws Exception {
		int resultTotal=0;	//操作的记录数
		/**
		 * 判断是添加还是修改
		 */
		if (customerReprieve.getId()==null) {
			
			resultTotal = customerReprieveService.add(customerReprieve);
		} else {
			resultTotal = customerReprieveService.update(customerReprieve);
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
	 * 删除客户记录
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="id",required=false) String id, HttpServletResponse response) throws Exception {
		
		customerReprieveService.delete(Integer.parseInt(id));
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
