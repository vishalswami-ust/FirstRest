package com.rest;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api.1.0")
public class Greet {
	@GetMapping
	@RequestMapping("/msg")
	public String message() {
		return "OLA! Save Harithik.";
	}
	
	
	
	@GetMapping
	@RequestMapping("/time")
	public String getTime() {
		return Calendar.getInstance().getTime() +"";
	}
	
	
	@GetMapping
	@RequestMapping("/{gender}")
	public String genderMsg(@PathVariable String gender) {
		if(gender.equals("Female")) {
			return "Welcome Miss";
		}
		if(gender.equals("Male")) {
			return "Welcome MR";
		}
		else
			return "Welcome LGBTQ";
	}

	
	@GetMapping
	@RequestMapping("/namegender/{name}/{gender}")
	public String name_gender(@PathVariable String name, @PathVariable String gender) {
		if(gender.equals("Female")) {
			return "Welcome Miss" + name;
		}
		if(gender.equals("Male")) {
			return "Welcome MR " + name;
		}
		else
			return "Welcome LGBTQ" + name;
	}
}
