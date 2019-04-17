package com.ipms.mapper;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.utils.QueryUtils;

public interface ComeFromHomeMapper {
	
	Integer findPlanAmountConditional(QueryUtils queryUtils);
	
	List<Plan> findPagePlans(QueryUtils queryUtils);
	
	Integer findLikeAmountConditional(QueryUtils queryUtils);
	
	List<Plan> findLikePlans(QueryUtils queryUtils);
	
	// 不带状态
	Integer findLikeAmountConditional01(QueryUtils queryUtils);
	
	List<Plan> findLikePlans01(QueryUtils queryUtils);
}
