package com.pretzero.fitsure.model.dto;

import java.util.Date;

public class Goal {
    private int goalId;
    private int userId;
    private int dayGoal;
    private int weekGoal;
    private Date startDay;
    private Date expireDay;
    private boolean exchange;
    private boolean cancel;
    
    public Goal() {}
    
	public Goal(int goalId, int userId, int dayGoal, int weekGoal, Date startDay, Date expireDay, boolean exchange,
			boolean cancel) {
		super();
		this.goalId = goalId;
		this.userId = userId;
		this.dayGoal = dayGoal;
		this.weekGoal = weekGoal;
		this.startDay = startDay;
		this.expireDay = expireDay;
		this.exchange = exchange;
		this.cancel = cancel;
	}
	
	
	public int getGoalId() {
		return goalId;
	}
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDayGoal() {
		return dayGoal;
	}
	public void setDayGoal(int dayGoal) {
		this.dayGoal = dayGoal;
	}
	public int getWeekGoal() {
		return weekGoal;
	}
	public void setWeekGoal(int weekGoal) {
		this.weekGoal = weekGoal;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getExpireDay() {
		return expireDay;
	}
	public void setExpireDay(Date expireDay) {
		this.expireDay = expireDay;
	}
	public boolean isExchange() {
		return exchange;
	}
	public void setExchange(boolean exchange) {
		this.exchange = exchange;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

    // Getters and Setters
}

