package com.ipms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ipms.mapper.ComeFromHomeMapper;
import com.ipms.pojo.Plan;
import com.ipms.service.ComeFromHomeService;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=true)
public class ComeFromHomeServiceImpl implements ComeFromHomeService {
	
	@Autowired 
	private ComeFromHomeMapper comeFromHomeMapper;
	
	@Override
	public Page<Plan> findPage(QueryUtils queryUtils) {
		Page<Plan> page = new Page<Plan>();
		// 每页显示的计划数10
		page.setAmountPerPage(10);
		// 通过状态和用户ID查询到的计划总数
		Integer pageTotal = comeFromHomeMapper.findPlanAmountConditional(queryUtils);
		page.setItemsTotal(pageTotal);
		// 总共多少页
		Integer pageNumber = pageTotal / 10 + 1;
		page.setPageNumber(pageNumber);
		
		return page;
	}

	@Override
	public List<Plan> findFirstPagePlans(QueryUtils queryUtils) {
		return comeFromHomeMapper.findFirstPagePlans(queryUtils);
	}

}
