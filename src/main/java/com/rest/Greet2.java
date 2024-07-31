package com.rest;

import  org.springframework.http.HttpHeaders;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//API 2.o


@RestController
@RequestMapping("/rest/api.2.0")
public class Greet2 {
	
	
	@GetMapping
	@RequestMapping("/msg")
	public ResponseEntity<String> message() {
		ResponseEntity<String> r = new ResponseEntity<>("OLA! Save Harithik.", HttpStatus.OK);
		return r;
	}
	
	
	
	@GetMapping
	@RequestMapping("/time")
	public ResponseEntity<String> getTime() {
		return ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime()+ "");
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
	public ResponseEntity<String> name_gender(@RequestHeader HttpHeaders headers, @PathVariable String name, @PathVariable String gender) {
		//HttpHeaders head = new HttpHeaders();
		/*
		 * Set<String> set = headers.keySet(); Iterator<String> keys = set.iterator();
		 * 
		 * String keyStr = null; while(keys.hasNext()) { keyStr+= keys.next() + "\n"; }
		 * 
		 * Set<Entry<String,List<String>>> entries = headers.entrySet(); String
		 * keyValueStr = null; Iterator iter2 = entries.iterator();
		 * while(iter2.hasNext()) { keyValueStr += iter2.next() + "\n"; }
		 */
		HttpHeaders header2 = new HttpHeaders();
		header2.setContentType(MediaType.TEXT_HTML);
		System.out.print(header2.getAcceptLanguageAsLocales());
		header2.set("Accept-Language", "hi-IN");
		header2.set("UST", "GammaTraining#6");
		return ResponseEntity.status(HttpStatus.OK).headers(header2).body("Hello");
		
	}
	

	@PostMapping
	@RequestMapping("/namegender1")
	public ResponseEntity<String> gendermsg2(@RequestBody Member member) {
			if(member.getGender().equals("Female"))
				return ResponseEntity.ok("Welcome Miss" + member.getName());
			else if(member.getGender().equals("Male"))
				return ResponseEntity.ok("Welcome Mr." + member.getName());
			else
				return ResponseEntity.ok("Welcome" + member.getName());
	}
}
