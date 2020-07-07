package com.test.anagram;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.anagram.services.AnagramServices;

@SpringBootTest
class AnagramServiceTest {

	@Autowired
	private AnagramServices anagramServices;

	@Test
	@DisplayName("Anagaram generation service test ")
	void testAngagram() {
//		   AnagramServices anagramServices= new AnagramServices();

		String word = "book";

		List<String> anagrams = anagramServices.getAnagrams(word);
		assertEquals(anagrams, Arrays.asList("book", "koob"));
	}

}
