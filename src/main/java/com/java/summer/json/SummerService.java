package com.java.summer.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.java.summer.util.HttpUtil;

@Service
public class SummerService implements SummerServiceInterFace {
	
	@Autowired
	SummerDaoInterFace SDI;
	
	HashMap<String, Object> param;

	@Override
	public ModelAndView json(String menu, String type, HttpServletRequest req) {
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		
		param.put("param", map);
		
		return HttpUtil.mJview(SDI.join(param));
	}

	
}
