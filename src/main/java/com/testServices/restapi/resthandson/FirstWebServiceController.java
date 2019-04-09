package com.testServices.restapi.resthandson;

import java.awt.PageAttributes.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;
@RestController
public class FirstWebServiceController {
	
	
	@GetMapping(path="/first-service")
	public String firstWebService() {
		return "Hello Deadpool";
	}
	
	@GetMapping(path="/first-service/print-name/{name}")
	public String firstWebServiceName(@PathVariable String name) {
		switch(name){
			case "shivam":
				return "hELLO " + "Wade Wilson";
			case "shagun":
				return "hELLO " + "Vanessa";
			default:
				break;
		}
		return "Hello " + name;
	}
	
	@RequestMapping(path="/first-service/request-map")
	public String firstWebServiceRequest() {
		return "Hello Man";
	}
	
	@RequestMapping(path="/first-service/print-name/{name}/{company}")
	public String firstWebServiceNameRequestName(@PathVariable String name, @PathVariable String company) {
		switch(name){
			case "shivam":
				return "hELLO " + "Wade Wilson" + company;
			case "shikha":
				return "hELLO " + "Vanessa" + company;
			default:
				break;
		}
		return "Hello " + name + company;
	}
	
    @PostMapping("/square/{number}")
    public int postMapping(@PathVariable int number) {
        return number * number;
    }
    
    @PostMapping("/sum/{number1}/{number2}")
    public int postMapping2(@PathVariable int number1,
    						@PathVariable int number2) {
        return number1 + number2;
    }
}
