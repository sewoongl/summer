package com.java.summer.json;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SummerDao implements SummerDaoInterFace {
	
	@Resource(name="sqlSession")
	SqlSession session;

	@Override
	public HashMap<String, Object> join(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		if("List".equals(param.get("type"))) {
			result.put("result", session.selectList(param.get("menu") + ".summerList"));
		} else if ("One".equals(param.get("type"))) {
			System.out.println(param);
			result.put("result", session.selectOne(param.get("menu") + ".summerOne", param.get("param")));
		}
		
		
		
		return result;
	}

}
