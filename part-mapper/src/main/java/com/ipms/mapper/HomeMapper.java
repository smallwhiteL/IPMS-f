package com.ipms.mapper;

import java.util.List;

import com.ipms.pojo.Plan;
import com.ipms.pojo.User;

public interface HomeMapper {
	
	Integer findToDo(String plan_userId);
	
	Integer findDoing(String plan_userId);
	
	Integer findDone(String plan_userId);
	
	Integer findFailed(String plan_userId);
	
	List<Plan> listToDo(String plan_userId);
	
	List<Plan> listDoing(String plan_userId);
	
	List<Plan> listDone(String plan_userId);
	
	List<Plan> listFailed(String plan_userId);
	
	void addPlan(Plan plan);
	
	void deletePlan(Integer plan_id);
	
	Plan getPlanById(Integer plan_id);
	
	void updatePlan(Plan plan);
	
	void updateUser(User user);
	
	String getportraitByUserId(String userId);
	
}
