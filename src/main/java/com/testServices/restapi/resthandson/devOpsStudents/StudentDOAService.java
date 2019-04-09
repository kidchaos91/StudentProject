package com.testServices.restapi.resthandson.devOpsStudents;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StudentDOAService {
	private static int studentCount = 5;
	private static ArrayList<DevOpsStudents> devOpsClass = new ArrayList<DevOpsStudents>();
	
	public StudentDOAService() {
		devOpsClass.add(new DevOpsStudents(1, "Shivam", new Date()));
		devOpsClass.add(new DevOpsStudents(2, "Shubham", new Date()));
		devOpsClass.add(new DevOpsStudents(3, "Geet", new Date()));
		devOpsClass.add(new DevOpsStudents(4, "Ballu", new Date()));
		devOpsClass.add(new DevOpsStudents(5, "Parv", new Date()));
		devOpsClass.add(new DevOpsStudents(6, "Yadavji", new Date()));
	}
	
	public ArrayList<DevOpsStudents> displayStudents(){
	
		return devOpsClass;
	}
	
	public String addStudent(DevOpsStudents student) {
		devOpsClass.add(student);
		return "Student added successfully.";
	}
	
	public String updateStudent(int id, DevOpsStudents newStudent) {
		Boolean flag = false;
		for(DevOpsStudents student: devOpsClass) {
			if(student.getStudentID() == id) {
				student.setStudentName(newStudent.getStudentName());
				student.setJoinDate(newStudent.getJoinDate());
				flag = true;
			}
		}
//		devOpsClass.set(id-1, newStudent);
		if(flag)
			return "Student updated successfully.";
		else
			return "Student with id: " + id + "does not exist";
	}

	public void deleteStudent(int id) {
		devOpsClass.removeIf(p -> p.getStudentID() == id);
	}



}
