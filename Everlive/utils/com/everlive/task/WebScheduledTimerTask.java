package com.everlive.task;import com.everlive.user.bo.UserForm;import com.everlive.user.service.JudgeStarService;import com.everlive.user.service.UserManagerService;public class WebScheduledTimerTask {		private UserManagerService userManagerService; 	private JudgeStarService judgeStarService;	protected void exportFUandUPByPlan(){				String function = "";		UserForm userForm = new UserForm();				judgeStarService.getStartList(userForm);		function = "getStartList";		judgeStarService.addTaskLog(function);//log1		//		judgeStarService.getSuspend1List(userForm);//		function = "getSuspend1List";//		judgeStarService.addTaskLog(function);//log2		//		judgeStarService.getSuspend2List(userForm);//		function = "getSuspend2List";//		judgeStarService.addTaskLog(function);//log3		//		judgeStarService.getSuspend3List(userForm);//		function = "getSuspend3List";//		judgeStarService.addTaskLog(function);//log4			}	public UserManagerService getUserManagerService() {		return userManagerService;	}	public void setUserManagerService(UserManagerService userManagerService) {		this.userManagerService = userManagerService;	}	public JudgeStarService getJudgeStarService() {		return judgeStarService;	}	public void setJudgeStarService(JudgeStarService judgeStarService) {		this.judgeStarService = judgeStarService;	}}