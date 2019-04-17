package com.ipms.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ipms.mapper.ComeFromHomeMapper;
import com.ipms.pojo.FormatPlanToJson;
import com.ipms.pojo.Plan;
import com.ipms.service.ComeFromHomeService;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=true)
public class ComeFromHomeServiceImpl implements ComeFromHomeService {
	
	@Autowired 
	private ComeFromHomeMapper comeFromHomeMapper;
	
	private Page page = new Page();

	@Override
	/**
	 * 将非格式化List<Plan>转为List<FormatPlanToJson>的公共方法
	 */
	public List<FormatPlanToJson> getFormatPlanCommonFunc(List<Plan> plansPage, QueryUtils queryUtils) {
		
		// 转为Json格式的Plan
		List<FormatPlanToJson> formatPlanToJsons = new ArrayList<>();
		// 遍历查询到的Plan
		for (Plan plan : plansPage) {
			// Date -> String
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String plan_starting_time = sdf.format(plan.getPlan_starting_time());
			String plan_ending_time = sdf.format(plan.getPlan_ending_time());
			// 判断状态并改为中文
			String formatStatus = "";
			if (plan.getPlan_status() == 1) {
				formatStatus = "待开始";
			} else if (plan.getPlan_status() == 2) {
				formatStatus = "进行中";
			} else if (plan.getPlan_status() == 3) {
				formatStatus = "已结束";
			} else if (plan.getPlan_status() == 4) {
				formatStatus = "已逾期";
			}
			// 将每一项Plan格式化为Json以输出到前端
			FormatPlanToJson formatPlanToJson = new FormatPlanToJson(plan.getPlan_id()+"", plan.getPlan_title(),
					plan_starting_time, plan_ending_time, plan.getPlan_describe(), formatStatus);
			// 将格式化后的Plan添加到List中
			formatPlanToJsons.add(formatPlanToJson);
		}
		return formatPlanToJsons;
	}
	
	@Override
	/**
	 * 通过状态, UserId, 页号, 页起始行查询该页信息
	 */
	public Page findPage(QueryUtils queryUtils) {
		
		// 每页显示的计划数10
		page.setAmountPerPage(10);
		
		// 通过状态和用户ID查询到的计划总数
		Integer pageTotal = comeFromHomeMapper.findPlanAmountConditional(queryUtils);
		page.setItemsTotal(pageTotal);
		
		// 总共多少页
		Integer pageNumber = pageTotal / 10 + 1;
		page.setPageNumber(pageNumber);
		// 页号
		page.setPage_index(queryUtils.getPage_index());
		
		// 未转为Json格式的Plan
		List<Plan> plansPage = findPagePlans(queryUtils);
		// 转为Json格式的Plan
		List<FormatPlanToJson> formatPlanToJsons = getFormatPlanCommonFunc(plansPage, queryUtils);
		page.setFormatPlanToJsons(formatPlanToJsons);
		
		return page;
	}

	@Override
	public List<Plan> findPagePlans(QueryUtils queryUtils) {
		return comeFromHomeMapper.findPagePlans(queryUtils);
	}

	
	@Override
	/**
	 * 模糊查询分页信息
	 */
	public Page findLikePage(QueryUtils queryUtils) {
		
		// 每页显示的计划数10
		page.setAmountPerPage(10);
		
		// 通过状态和用户ID查询到的计划总数
		Integer pageTotal = 0;
		if(queryUtils.getStatus() == null) {
			pageTotal = comeFromHomeMapper.findLikeAmountConditional01(queryUtils);
		} else {
			pageTotal = comeFromHomeMapper.findLikeAmountConditional(queryUtils);
		}
		page.setItemsTotal(pageTotal);
		
		// 总共多少页
		Integer pageNumber = pageTotal / 10 + 1;
		page.setPageNumber(pageNumber);
		
		// 页号
		page.setPage_index(queryUtils.getPage_index());
		
		// 未转为Json格式的Plan
		List<Plan> plansPage = findLikePagePlans(queryUtils);
		// 转为Json格式的Plan
		List<FormatPlanToJson> formatPlanToJsons = getFormatPlanCommonFunc(plansPage, queryUtils);
		page.setFormatPlanToJsons(formatPlanToJsons);
		
		return page;
	}

	@Override
	public List<Plan> findLikePagePlans(QueryUtils queryUtils) {
		if(queryUtils.getStatus() != null) {
			return comeFromHomeMapper.findLikePlans(queryUtils);
		}
		return comeFromHomeMapper.findLikePlans01(queryUtils);
	}
	
}
