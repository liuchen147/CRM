package com.lc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.entity.PageBean;
import com.lc.entity.Product;
import com.lc.service.ProductService;
import com.lc.util.ResponseUtil;
import com.lc.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	public ProductService productService;
	/**
	 * ��ѯ�û�����
	 * @param page
	 * @param rows
	 * @param s_product
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,Product s_product,HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productName", StringUtil.formatLike( s_product.getProductName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ�û�����
		List<Product> productList = productService.find(map);
		//��ȡ�û��ܼ�¼��
		Long total = productService.getTotal(map);
		JSONObject json = new JSONObject();
		//��productList����ת��Ϊjson��ʽ������
		JSONArray jsonArray = JSONArray.fromObject(productList);
		json.put("rows", jsonArray);
		json.put("total", total);
		ResponseUtil.write(response, json);
		return null;
	}
}
