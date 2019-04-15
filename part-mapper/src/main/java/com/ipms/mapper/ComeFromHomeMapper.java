package com.ipms.mapper;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.utils.QueryUtils;

public interface ComeFromHomeMapper {
	
	Integer findPlanAmountConditional(QueryUtils queryUtils);
	
	List<Plan> findFirstPagePlans(QueryUtils queryUtils);
	
}
