package com.ipms.service;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

public interface ComeFromHomeService {
	
	Page<Plan> findPage(QueryUtils queryUtils);
	
	List<Plan> findFirstPagePlans(QueryUtils queryUtils);
	
}
