package com.java.mphasis.leaveproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO
{
	static List<Leave> leaveList;
	
	static
	{
		leaveList = new ArrayList<Leave>();
	}
	
	public String addLeaveDAO(Leave leave)
	{
		leaveList.add(leave);
		return "Leave Added Successfully..";
	}
	
	public List<Leave> showLeaveDAO()
	{
		return leaveList;
	}
	
	public Leave searchLeaveDAO(int leaveID)
	{
		Leave result = null;
		for (Leave leave : leaveList) 
		{
			if(leave.getLeaveID() == leaveID)
			{
				result = leave;
				break;
			}
		}
		return result;
	}
	
	public String deleteLeaveDAO(int leaveID)
	{
		Leave leave = searchLeaveDAO(leaveID);
		if(leave!= null)
		{
			leaveList.remove(leave);
			return "Record deleted successfully..";
		}
		else
		{
			return "Record Not Found..";
		}
	}
	
	public String updateLeaveDAO(Leave newLeave)
	{
		Leave oldLeave = searchLeaveDAO(newLeave.getLeaveID());
		
		if(oldLeave != null)
		{
			oldLeave.setLeaveID(newLeave.getLeaveID());
			oldLeave.setManagerID(newLeave.getManagerID());
			oldLeave.setLeaveStart(newLeave.getLeaveStart());
			oldLeave.setLeaveEnd(newLeave.getLeaveEnd());
			oldLeave.setLeaveType(newLeave.getLeaveType());
			oldLeave.setLeaveStatus(newLeave.getLeaveStatus());
			oldLeave.setLeaveAppliedOn(newLeave.getLeaveAppliedOn());
			oldLeave.setManagerComment(newLeave.getManagerComment());
			
			return "record Updated Successfully..";
		}
		else
		{
			return "Record not Found..";
		}
	}
	
	public String readLeaveFileDAO() throws ClassNotFoundException, IOException
	{
		FileInputStream fin = new FileInputStream("F:/Nirav/leave.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		
		leaveList = (List<Leave>) objin.readObject();
		
		objin.close();
		fin.close();
		return "File read Successfully..";
	}
	
	public String writeLeaveFileDAO() throws IOException
	{
		FileOutputStream fout = new FileOutputStream("F:/Nirav/leave.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		
		objout.writeObject(leaveList);
		
		objout.close();
		fout.close();
		return "File Write Successfully..";
	}
	
	public int generateLeaveID()
	{
		int leaveID = 0;
		int count = leaveList.size();
		
		if(count == 0)
		{
			leaveID = 1;
		}
		else
		{
			leaveID = count + 1;
		}
		return leaveID;
	}
	
	public String approveDenie(int leaveID, String leaveStatus, String managerComment)
	{
		Leave leave = searchLeaveDAO(leaveID);
		
		if(leave != null)
		{
			leave.setLeaveStatus(LeaveStatus.valueOf(leaveStatus));
			leave.setManagerComment(managerComment);
			return "leave Status Updated..";
		}
		else
		{
			return "Invalid LeaveID..";
		}
	}
}