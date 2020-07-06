package com.test.anagram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.anagram.services.AnagramServices;

@RestController

public class AnagramController {
	
	@Autowired
	AnagramServices anagramServices;
	
	 @RequestMapping("/")
	  public String home() {
	    return "Hello Anagram World";
	  }
	
	@GetMapping("/anagram/{word}")
	public List<String> getAnagrams(@PathVariable ("word") String word){
		return anagramServices.getAnagrams(word);
		
	}

}
