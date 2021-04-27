package com.java.mphasis.leaveproject;

import java.io.IOException;
import java.util.List;

public class LeaveBAL
{
	public static String addLeaveBAL(Leave leave)
	{
		return new LeaveDAO().addLeaveDAO(leave);
	}
	
	public static List<Leave> showLeaveBAL()
	{
		return new LeaveDAO().showLeaveDAO();
	}
	
	public static Leave searchLeaveBAL(int leaveID)
	{
		return new LeaveDAO().searchLeaveDAO(leaveID);
	}
	
	public static String deleteLeaveBAL(int leaveID)
	{
		return new LeaveDAO().deleteLeaveDAO(leaveID);
	}
	
	public static String updateLeaveBAL(Leave leave)
	{
		return new LeaveDAO().updateLeaveDAO(leave);
	}
	
	public static String readLeaveBAL() throws ClassNotFoundException, IOException
	{
		return new LeaveDAO().readLeaveFileDAO();
	}
	
	public static String writeLeaveBAL() throws IOException
	{
		return new LeaveDAO().writeLeaveFileDAO();
	}
	
	public static int generateLeaveID()
	{
		return new LeaveDAO().generateLeaveID();
	}
	
	public static String approveDenie(int leaveID, String leaveStatus, String managerComment)
	{
		return new LeaveDAO().approveDenie(leaveID, leaveStatus, managerComment);
	}
}
