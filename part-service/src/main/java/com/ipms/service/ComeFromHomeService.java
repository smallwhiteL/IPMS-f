package com.ipms.service;

import java.util.List;

import com.ipms.pojo.FormatPlanToJson;
import com.ipms.pojo.Plan;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

public interface ComeFromHomeService {
	
	List<FormatPlanToJson> getFormatPlanCommonFunc(List<Plan> PagePlans, QueryUtils queryUtils);
	
	Page findPage(QueryUtils queryUtils);
	
	List<Plan> findPagePlans(QueryUtils queryUtils);
	
	Page findLikePage(QueryUtils queryUtils);
	
	List<Plan> findLikePagePlans(QueryUtils queryUtils);
	
	Integer findByEndTimeAndUserId(QueryUtils queryUtils);
	
	List<Plan> findPlansByEndTime(QueryUtils queryUtils);
	
	Page findEndTimePage(QueryUtils queryUtils);
}
