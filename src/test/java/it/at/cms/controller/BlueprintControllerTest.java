package it.at.cms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import it.at.cms.repo.Blueprint;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlueprintControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTmpl;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		final Map<String, Object> request = new HashMap<>();
		request.put("a", "123");
		request.put("b", "This is my name");
		
		//run
		final Blueprint result = restTmpl.postForObject(URI.create("http://localhost:" + port + "/blueprint"), request, Blueprint.class);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(request, result.getProperties());
	}
	
}
