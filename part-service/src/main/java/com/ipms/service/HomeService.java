package com.ipms.service;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.pojo.User;

public interface HomeService {
	
	Integer findToDoService(String plan_userId);
	
	Integer findDoingService(String plan_userId);
	
	Integer findDoneService(String plan_userId);
	
	Integer findFailedService(String plan_userId);
	
	List<Plan> listToDo(String plan_userId);
	
	List<Plan> listDoing(String plan_userId);
	
	List<Plan> listDone(String plan_userId);
	
	List<Plan> listFailed(String plan_userId);
	
	void addPlan(Plan plan);
	
	void deletePlan(Integer plan_id);
	
	Plan getPlanById(Integer plan_id);
	
	void updatePlan(Plan plan);
	
	void updateUser(User user);
	
	// 根据用户ID查询头像路径
	String getportraitByUserId(String userId);
	
}
