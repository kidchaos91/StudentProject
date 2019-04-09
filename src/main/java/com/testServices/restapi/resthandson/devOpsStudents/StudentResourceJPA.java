package com.testServices.restapi.resthandson.devOpsStudents;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentResourceJPA {
	@Autowired //spring framework
	private StudentRepository studentRepo;
	
	@GetMapping("/jpa/getAllStudents")
	public List<DevOpsStudents> displayAllStudents(){
		System.out.println("here");
		return studentRepo.findAll();
	}
	
	@PostMapping("/jpa/addStudent")
	public void addStudent(@RequestBody DevOpsStudents student) {
		DevOpsStudents newStudent = studentRepo.save(student);
		
	}
	
	@PutMapping("/jpa/updateStudent/{id}")
	public ResponseEntity<DevOpsStudents> updateStudent(@PathVariable int id, @RequestBody DevOpsStudents newStudent) {
		Optional<DevOpsStudents> foundStudentOptional = studentRepo.findById(id);
		if(!foundStudentOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		newStudent.setStudentID(id);
		studentRepo.save(newStudent);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/jpa/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentRepo.deleteById(id);
		return "Student deleted successfully.";
	}
}
