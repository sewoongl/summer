package com.java.summer.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class HttpUtil {
	
	public static HashMap<String, Object> getParamMap(HttpServletRequest req){
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Enumeration<?> enums = req.getParameterNames();//에뉴멀레이션 - 이미 정해져있는 요소에 대한것을 사용자의 임의로 뽑아 낼때 
		while(enums.hasMoreElements()) {
			String paramName = enums.nextElement().toString();
		result.put(paramName, req.getParameter(paramName));	
		}
		
		return result;
		
	}
	
	public static ModelAndView mJview(HashMap<String, Object> hmp) {
		
		ModelAndView mav = new ModelAndView();
		
		JSONObject j = new JSONObject();
		j = JSONObject.fromObject(JSONSerializer.toJSON(hmp));
		mav.addObject("temp",j); //키:벨류
		mav.setViewName("summerJsp"); //화면이름
		
		return mav;
	}
	
}
