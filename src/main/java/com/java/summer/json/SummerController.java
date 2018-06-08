package com.java.summer.json;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.summer.util.HttpUtil;

@Controller
public class SummerController {
	
	@Autowired
	SummerServiceInterFace SSI;
	
	@RequestMapping("/pll/{menu}/{type}")
	public ModelAndView summer(
			@PathVariable("menu") String menu,
			@PathVariable("type") String type,
			HttpServletRequest req) {
		
		return SSI.json(menu, type, req);
	}
	
	@RequestMapping("/pll2/{type2}")
	public String summer(@PathVariable("type2") String type, HttpServletRequest req, Model model) {
		String view = "";
		model.addAttribute("QueryString", HttpUtil.getParamMap(req));
		if("SelectOneView".equals(type)) {
			view = "SummerOne";
		}
		return view;
		
	}
	
}
