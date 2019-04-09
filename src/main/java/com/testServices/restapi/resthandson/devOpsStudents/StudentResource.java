package com.testServices.restapi.resthandson.devOpsStudents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentResource {
	@Autowired //spring framework
	private StudentDOAService service;
	
	@GetMapping("/getAllStudents")
	public List<DevOpsStudents> displayAllStudents(){
		return service.displayStudents();
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody DevOpsStudents student) {
		return service.addStudent(student);
		
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody DevOpsStudents newStudent) {
		return service.updateStudent(id, newStudent);
	}
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
		return "Student deleted successfully.";
	}
}
