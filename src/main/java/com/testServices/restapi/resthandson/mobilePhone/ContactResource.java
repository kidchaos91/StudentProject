package com.testServices.restapi.resthandson.mobilePhone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testServices.restapi.resthandson.devOpsStudents.DevOpsStudents;
import com.testServices.restapi.resthandson.devOpsStudents.StudentDOAService;

@RestController
public class ContactResource {
	@Autowired //spring framework
	private ContactDAOService service;
	
	@GetMapping("/getAllContacts")
	public List<Contacts> displayAllStudents(){
		return service.displayContacts();
	}
	
	@PostMapping("/addContact")
	public String addContact(@RequestBody Contacts contact) {
		return service.addContact(contact);
	}
	
	@PutMapping("/updateContact/{number}")
	public String updateStudent(@PathVariable String number, @RequestBody Contacts newContacts) {
		return service.updateContact(number, newContacts);
	}
	
	@PutMapping("/updateContactEmail/{number}")
	public String updateStudent(@PathVariable String number, @RequestBody String email) {
		return service.updateContactEmail(number, email);
	}
	
	
	@DeleteMapping("/deleteContact/{number}")
	public String deleteStudent(@PathVariable String number) {
		service.deleteContact(number);
		return "Contact deleted successfully.";
	}
}
