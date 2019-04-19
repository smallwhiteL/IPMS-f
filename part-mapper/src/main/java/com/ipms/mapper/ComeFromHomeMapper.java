package com.ipms.mapper;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.utils.QueryUtils;

public interface ComeFromHomeMapper {
	
	Integer findPlanAmountConditional(QueryUtils queryUtils);
	
	List<Plan> findPagePlans(QueryUtils queryUtils);
	
	// 带状态
	Integer findLikeAmountConditional(QueryUtils queryUtils);
	
	List<Plan> findLikePlans(QueryUtils queryUtils);
	
	// 不带状态
	Integer findLikeAmountConditional01(QueryUtils queryUtils);
	
	List<Plan> findLikePlans01(QueryUtils queryUtils);
	
	// 根据截止日期及用户ID查询计划数量
	Integer findByEndTimeAndUserId(QueryUtils queryUtils);
	
	List<Plan> findPlansByEndTime(QueryUtils queryUtils);
}
