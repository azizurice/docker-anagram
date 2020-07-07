package com.test.anagram;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AnagramApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnagramControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAListOfWords() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		// ResponseEntity<String> response = restTemplate.exchange(getRootUrl() +
		// "/anagram/word", HttpMethod.GET, entity, String.class);

		ResponseEntity<List<String>> response = restTemplate.exchange(getRootUrl() + "/anagram/book", HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<String>>() {
				});

		assertNotNull(response.getBody());
	}

	@Test
	public void testGetAllAnagrams() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<List<String>> response = restTemplate.exchange(getRootUrl() + "/anagram/book", HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<String>>() {
				});
		List<String> anagrams = response.getBody();
		System.out.println(anagrams);

		assertEquals(anagrams, Arrays.asList("book", "koob"));
	}

}