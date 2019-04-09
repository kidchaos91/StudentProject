package com.testServices.restapi.resthandson.devOpsStudents;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DevOpsStudents {
	@Id
	@GeneratedValue
	private int studentID;
	private String studentName;
	private Date joinDate;
	
	public DevOpsStudents() {
		
	}
	
	public DevOpsStudents(int studentID, String studentName, Date joinDate) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.joinDate = joinDate;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	
//	@Override
//	public String toString() {
//		return "DevOpsStudents [studentID=" + studentID + ", studentName=" + studentName + ", joinDate=" + joinDate
//				+ "]";
//	}
}
