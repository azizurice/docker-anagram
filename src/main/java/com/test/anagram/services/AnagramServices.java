package com.test.anagram.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnagramServices {
	
	public List<String> getAnagrams(String word){
		List<String> words=new ArrayList<String>();
		words.add(word);
		words.add((new StringBuilder(word).reverse().toString()));
		return words;
		
		
	}

}
