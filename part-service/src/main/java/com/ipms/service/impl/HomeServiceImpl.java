package com.ipms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ipms.mapper.HomeMapper;
import com.ipms.pojo.Plan;
import com.ipms.service.HomeService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=true)
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeMapper homeMapper;

	@Override
	public Integer findToDoService(String plan_userId) {

		return homeMapper.findToDo(plan_userId);
	}

	@Override
	public Integer findDoingService(String plan_userId) {
		return homeMapper.findDoing(plan_userId);
	}

	@Override
	public Integer findDoneService(String plan_userId) {
		return homeMapper.findDone(plan_userId);
	}

	@Override
	public Integer findFailedService(String plan_userId) {
		return homeMapper.findFailed(plan_userId);
	}

	@Override
	public List<Plan> listToDo(String plan_userId) {
		return homeMapper.listToDo(plan_userId);
	}

	@Override
	public List<Plan> listDoing(String plan_userId) {
		return homeMapper.listDoing(plan_userId);
	}

	@Override
	public List<Plan> listDone(String plan_userId) {
		return homeMapper.listDone(plan_userId);
	}

	@Override
	public List<Plan> listFailed(String plan_userId) {
		return homeMapper.listFailed(plan_userId);
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=false)
	public void addPlan(Plan plan) {
		homeMapper.addPlan(plan);
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=false)
	public void deletePlan(Integer plan_id) {
		homeMapper.deletePlan(plan_id);
	}

}
