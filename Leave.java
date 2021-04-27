package com.java.mphasis.leaveproject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leave implements Serializable
{
	private int leaveID;
	private int managerID;
	private Date leaveStart;
	private Date leaveEnd;
	LeaveType leaveType;
	LeaveStatus leaveStatus;
	private int noOfDate;
	private String leaveAppliedOn;
	private String managerComment;
	
	public int getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public Date getLeaveStart() {
		return leaveStart;
	}
	public void setLeaveStart(Date leaveStart) {
		this.leaveStart = leaveStart;
	}
	public Date getLeaveEnd() {
		return leaveEnd;
	}
	public void setLeaveEnd(Date leaveEnd) {
		this.leaveEnd = leaveEnd;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public int getNoOfDate() {
		return noOfDate;
	}
	public void setNoOfDate(int noOfDate) {
		this.noOfDate = noOfDate;
	}
	public String getLeaveAppliedOn() {
		return leaveAppliedOn;
	}
	public void setLeaveAppliedOn(String leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}
	public String getManagerComment() {
		return managerComment;
	}
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Leave(int leaveID, int managerID, Date leaveStart, Date leaveEnd, LeaveType leaveType,
			LeaveStatus leaveStatus, int noOfDate, String leaveAppliedOn, String managerComment) {
		this.leaveID = leaveID;
		this.managerID = managerID;
		this.leaveStart = leaveStart;
		this.leaveEnd = leaveEnd;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.noOfDate = noOfDate;
		this.leaveAppliedOn = leaveAppliedOn;
		this.managerComment = managerComment;
	}
	
	@Override
	public String toString() 
	{
		
		Date date1 = new Date();
		Date date2 = new Date();
		Date dt = new Date();
		
		date1 = leaveStart;
		
		date2 = leaveEnd;
		
		long time_diff = date2.getTime() - date1.getTime();  
    
        long days_diff = (time_diff / (1000*60*60*24)) % 365;
		
		return "Leave [leaveID=" + leaveID + ", managerID=" + managerID + ", leaveStart=" + leaveStart + ", leaveEnd="
				+ leaveEnd + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus + ", noOfDate=" + days_diff+1
				+ ", leaveAppliedOn=" + dt + ", managerComment=" + managerComment + "]";
	}
}