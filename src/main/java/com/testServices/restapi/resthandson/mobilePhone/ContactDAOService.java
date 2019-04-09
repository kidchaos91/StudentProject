package com.testServices.restapi.resthandson.mobilePhone;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.testServices.restapi.resthandson.devOpsStudents.DevOpsStudents;

import java.util.ArrayList;

@Component
public class ContactDAOService {
	private static int contactCount = 5;
	private static ArrayList<Contacts> contactsClass = new ArrayList<Contacts>();
	
	public ContactDAOService() {
		contactsClass.add(new Contacts("Shivam", "Saxena", "5188713986", "shivamsaxena0791@gmail.com"));
		contactsClass.add(new Contacts("Shubham", "Yadav", "8860768179", "shubham.yadav@gmail.com"));
		contactsClass.add(new Contacts("Riddhi", "Seth", "9560940427", "riddhi.seth@gmail.com"));
		contactsClass.add(new Contacts("Jake", "Goodson", "7718324567", "jake.goodson@gmail.com"));
		contactsClass.add(new Contacts("Taz", "Kwok", "6169345687", "tkwok@gmail.com"));
		contactsClass.add(new Contacts("Vij", "Oberoi", "6759084312", "voberoi@gmail.com"));
	}
	
	public ArrayList<Contacts> displayContacts(){
		return contactsClass;
	}
	
	public String addContact(Contacts newContact) {
		for(Contacts contact: contactsClass) {
			if(newContact.getfirstName().equals(contact.getfirstName())) {
				return "Contact already exists.";
			}else {
				contactsClass.add(newContact);
			}
		}
		
		return "Contact added successfully.";
	}
	
	public String updateContact(String number, Contacts newContact) {
		Boolean flag = false;
		for(Contacts contact: contactsClass) {
			if(contact.getPhoneNumber().equals(number)) {
				contact.setPhoneNumber(newContact.getPhoneNumber());
				contact.setFirstName(newContact.getfirstName());
				contact.setLastName(newContact.getLastName());
				contact.setEmail(newContact.getEmail());
				flag = true;
			}
		}
		if(flag)
			return "Contact updated successfully.";
		else
			return "Contact with id: " + number + " does not exist";
	}
	
	public String updateContactEmail(String number, String email) {
		Boolean flag = false;
		for(Contacts contact: contactsClass) {
			if(contact.getPhoneNumber().equals(number)) {
				contact.setEmail(email);
				flag = true;
			}
		}
		if(flag)
			return "Contact updated successfully.";
		else
			return "Contact with id: " + number + " does not exist";
	}
	
	public void deleteContact(String number) {
		contactsClass.removeIf(p -> p.getPhoneNumber().equals(number));
	}
}
