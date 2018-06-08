package com.java.summer.json;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface SummerServiceInterFace {
	
	public ModelAndView json(String menu, String type, HttpServletRequest req);
	
}
